package com.example.ToDoApp.service;

import com.example.ToDoApp.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    Task findById(int id);

    void save(Task task);

    void deleteById(int id);
}
