package com.ToDoGorevTakipSistemi.ToDoTask.controller;


import com.ToDoGorevTakipSistemi.ToDoTask.dto.request.ChangeStatusRequest;
import com.ToDoGorevTakipSistemi.ToDoTask.dto.request.CreateTaskRequest;
import com.ToDoGorevTakipSistemi.ToDoTask.dto.request.UpdateTaskRequest;
import com.ToDoGorevTakipSistemi.ToDoTask.dto.response.TaskResponse;
import com.ToDoGorevTakipSistemi.ToDoTask.model.Priority;
import com.ToDoGorevTakipSistemi.ToDoTask.model.Status;
import com.ToDoGorevTakipSistemi.ToDoTask.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody CreateTaskRequest request) {
        TaskResponse response = taskService.createTask(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }


    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTaskRequest request) {
        return ResponseEntity.ok(taskService.updateTask(id, request));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping("/{id}/status")
    public ResponseEntity<TaskResponse> changeStatus(
            @PathVariable Long id,
            @Valid @RequestBody ChangeStatusRequest request) {
        return ResponseEntity.ok(taskService.changeStatus(id, request));
    }


    @GetMapping("/filter/status")
    public ResponseEntity<List<TaskResponse>> filterByStatus(@RequestParam Status status) {
        return ResponseEntity.ok(taskService.filterByStatus(status));
    }


    @GetMapping("/filter/priority")
    public ResponseEntity<List<TaskResponse>> filterByPriority(@RequestParam Priority priority) {
        return ResponseEntity.ok(taskService.filterByPriority(priority));
    }


    @GetMapping("/search")
    public ResponseEntity<List<TaskResponse>> searchByTitle(@RequestParam String keyword) {
        return ResponseEntity.ok(taskService.searchByTitle(keyword));
    }
}
