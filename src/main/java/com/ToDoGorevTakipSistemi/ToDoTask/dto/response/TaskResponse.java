package com.ToDoGorevTakipSistemi.ToDoTask.dto.response;

import com.ToDoGorevTakipSistemi.ToDoTask.model.Priority;
import com.ToDoGorevTakipSistemi.ToDoTask.model.Status;
import com.ToDoGorevTakipSistemi.ToDoTask.model.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDateTime createdAt;
    private LocalDate dueDate;


    public TaskResponse(Long id, String title, String description, Status status,
                        Priority priority, LocalDateTime createdAt, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.createdAt = createdAt;
        this.dueDate = dueDate;
    }


    public static TaskResponse from(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getCreatedAt(),
                task.getDueDate()
        );
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}