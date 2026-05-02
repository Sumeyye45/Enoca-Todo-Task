package com.ToDoGorevTakipSistemi.ToDoTask.repository;


import com.ToDoGorevTakipSistemi.ToDoTask.model.Priority;
import com.ToDoGorevTakipSistemi.ToDoTask.model.Status;
import com.ToDoGorevTakipSistemi.ToDoTask.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(Status status);

    List<Task> findByPriority(Priority priority);

    List<Task> findByTitleContainingIgnoreCase(String keyword);
}
