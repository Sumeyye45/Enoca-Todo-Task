package com.ToDoGorevTakipSistemi.ToDoTask.dto.request;

import com.ToDoGorevTakipSistemi.ToDoTask.model.Status;
import jakarta.validation.constraints.NotNull;

public class ChangeStatusRequest {

    @NotNull(message = "Durum alanı zorunludur.")
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
