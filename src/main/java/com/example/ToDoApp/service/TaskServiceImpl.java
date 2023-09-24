package com.example.ToDoApp.service;

import com.example.ToDoApp.dao.TasksDAO;
import com.example.ToDoApp.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TasksDAO tasksDAO;

    @Autowired
    public TaskServiceImpl(TasksDAO tasksDAO) {
        this.tasksDAO = tasksDAO;
    }

    @Override
    @Transactional
    public List<Task> findAll() {
        return tasksDAO.findAll();
    }

    @Override
    @Transactional
    public Task findById(int id) {
        return tasksDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Task task) {
        tasksDAO.save(task);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        tasksDAO.deleteById(id);
    }
}
