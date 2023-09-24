package com.example.ToDoApp.dao;

import com.example.ToDoApp.entity.Task;

import java.util.List;

public interface TasksDAO {

    List<Task> findAll();

    Task findById(int id);

    void save(Task task);

    void deleteById(int id);

}
