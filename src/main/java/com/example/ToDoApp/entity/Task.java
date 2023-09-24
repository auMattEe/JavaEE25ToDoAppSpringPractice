package com.example.ToDoApp.entity;

import jakarta.persistence.*;

//Database details
@Entity
@Table(name = "todos")
public class Task {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "completed")
    private Boolean completed;

    //Empty constructor
    public Task() {

    }

    //Constructor with two arguments
    public Task(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    //Getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    //toString()
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
