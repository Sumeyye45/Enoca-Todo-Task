package com.ToDoGorevTakipSistemi.ToDoTask.dto.request;

import com.ToDoGorevTakipSistemi.ToDoTask.model.Priority;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UpdateTaskRequest {
    @Size(min = 1, max = 100, message = "Başlık 1-100 karakter arasında olmalıdır.")
    private String title;

    @Size(max = 500, message = "Açıklama en fazla 500 karakter olabilir.")
    private String description;

    private Priority priority;

    @Future(message = "Bitiş tarihi bugünden ileri bir tarih olmalıdır.")
    private LocalDate dueDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
