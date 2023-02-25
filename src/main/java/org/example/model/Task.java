package org.example.model;

import org.example.entity.TaskEntity;

import java.util.Date;

public class Task {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private Date date;

    public static Task toModel(TaskEntity taskEntity) {
        Task model = new Task();
        model.setId(taskEntity.getId());
        model.setTitle(taskEntity.getTitle());
        model.setDescription(taskEntity.getDescription());
        model.setCompleted(taskEntity.isCompleted());
        model.setDate(taskEntity.getDate());
        return model;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
