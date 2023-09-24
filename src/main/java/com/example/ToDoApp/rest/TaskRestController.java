package com.example.ToDoApp.rest;

import com.example.ToDoApp.entity.Task;
import com.example.ToDoApp.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {

    private final TaskService taskService;

    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    //Exposing /task endpoint to get a list of tasks
    @GetMapping("/tasks")
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/tasks/{taskId}")
    public Task getTask(@PathVariable int taskId) {
        Task task = taskService.findById(taskId);
        if (task == null) {
            throw new RuntimeException("Task not found - " + taskId);
        }
        return task;
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        taskService.save(task);
        return task;
    }

    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task task) {
        taskService.save(task);
        return task;
    }

    //Adding mapping for DELETE /tasks/{taskId}
    @DeleteMapping("/tasks/{taskId}")
    public String deleteTask(@PathVariable int taskId) {
        Task task = taskService.findById(taskId);
        if (task == null) {
            throw new RuntimeException("Task id not found - " + taskId);
        }

        taskService.deleteById(taskId);

        return "Task with id - " + taskId + "was deleted";
    }
}
