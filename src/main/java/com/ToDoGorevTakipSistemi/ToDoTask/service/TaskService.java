package com.ToDoGorevTakipSistemi.ToDoTask.service;

import com.ToDoGorevTakipSistemi.ToDoTask.dto.request.ChangeStatusRequest;
import com.ToDoGorevTakipSistemi.ToDoTask.dto.request.CreateTaskRequest;
import com.ToDoGorevTakipSistemi.ToDoTask.dto.request.UpdateTaskRequest;
import com.ToDoGorevTakipSistemi.ToDoTask.dto.response.TaskResponse;
import com.ToDoGorevTakipSistemi.ToDoTask.model.Priority;
import com.ToDoGorevTakipSistemi.ToDoTask.model.Status;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(CreateTaskRequest request);

    List<TaskResponse> getAllTasks();

    TaskResponse getTaskById(Long id);

    TaskResponse updateTask(Long id, UpdateTaskRequest request);

    void deleteTask(Long id);

    TaskResponse changeStatus(Long id, ChangeStatusRequest request);

    List<TaskResponse> filterByStatus(Status status);

    List<TaskResponse> filterByPriority(Priority priority);

    List<TaskResponse> searchByTitle(String keyword);
}

