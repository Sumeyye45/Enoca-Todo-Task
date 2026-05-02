package com.ToDoGorevTakipSistemi.ToDoTask.service;

import com.ToDoGorevTakipSistemi.ToDoTask.dto.request.ChangeStatusRequest;
import com.ToDoGorevTakipSistemi.ToDoTask.dto.request.CreateTaskRequest;
import com.ToDoGorevTakipSistemi.ToDoTask.dto.request.UpdateTaskRequest;
import com.ToDoGorevTakipSistemi.ToDoTask.dto.response.TaskResponse;
import com.ToDoGorevTakipSistemi.ToDoTask.exception.TaskNotFoundException;
import com.ToDoGorevTakipSistemi.ToDoTask.model.Priority;
import com.ToDoGorevTakipSistemi.ToDoTask.model.Status;
import com.ToDoGorevTakipSistemi.ToDoTask.model.Task;
import com.ToDoGorevTakipSistemi.ToDoTask.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;


    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public TaskResponse createTask(CreateTaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle().trim());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());

        return TaskResponse.from(taskRepository.save(task));
    }


    @Override
    public List<TaskResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskResponse> responseList = new ArrayList<>();

        for (Task task : tasks) {
            responseList.add(TaskResponse.from(task));
        }

        return responseList;
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task == null) {
            throw new TaskNotFoundException(id);
        }

        return TaskResponse.from(task);
    }


    @Override
    public TaskResponse updateTask(Long id, UpdateTaskRequest request) {
        Task task = findTaskOrThrow(id);

        if (request.getTitle() != null && !request.getTitle().isBlank()) {
            task.setTitle(request.getTitle().trim());
        }
        if (request.getDescription() != null) {
            task.setDescription(request.getDescription());
        }
        if (request.getPriority() != null) {
            task.setPriority(request.getPriority());
        }
        if (request.getDueDate() != null) {
            task.setDueDate(request.getDueDate());
        }

        return TaskResponse.from(taskRepository.save(task));
    }


    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }


    @Override
    public TaskResponse changeStatus(Long id, ChangeStatusRequest request) {
        Task task = findTaskOrThrow(id);
        task.setStatus(request.getStatus());
        return TaskResponse.from(taskRepository.save(task));
    }


    @Override
    public List<TaskResponse> filterByStatus(Status status) {
        List<Task> tasks = taskRepository.findByStatus(status);
        List<TaskResponse> responseList = new ArrayList<>();

        for (Task task : tasks) {
            responseList.add(TaskResponse.from(task));
        }

        return responseList;
    }

    @Override
    public List<TaskResponse> filterByPriority(Priority priority) {
        List<Task> tasks = taskRepository.findByPriority(priority);
        List<TaskResponse> responseList = new ArrayList<>();

        for (Task task : tasks) {
            responseList.add(TaskResponse.from(task));
        }

        return responseList;
    }

    @Override
    public List<TaskResponse> searchByTitle(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            throw new IllegalArgumentException("Arama terimi boş olamaz.");
        }

        List<Task> tasks = taskRepository.findByTitleContainingIgnoreCase(keyword.trim());
        List<TaskResponse> responseList = new ArrayList<>();

        for (Task task : tasks) {
            responseList.add(TaskResponse.from(task));
        }

        return responseList;
    }

    private Task findTaskOrThrow(Long id) {
        Task task = taskRepository.findById(id).orElse(null);

        if (task == null) {
            throw new TaskNotFoundException(id);
        }

        return task;
    }
}