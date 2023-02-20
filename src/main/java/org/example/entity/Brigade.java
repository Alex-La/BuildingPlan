package org.example.entity;

import jakarta.persistence.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "brigades")
public class Brigade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "brigade", cascade = CascadeType.ALL)
    private List<Task> taskIds = new ArrayList<>();

    /*public void addTask(Task task) {
        taskIds.add(task);
        task.setBrigade(this);
    }

    public void removeTask(Task task) {
        taskIds.remove(task);
        task.setBrigade(null);
    }*/

    public Brigade() {
    }

    public Brigade(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Brigade(String title, String description, List<Task> taskIds) {
        this.title = title;
        this.description = description;
        this.taskIds = taskIds;
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

    public List<Task> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<Task> taskIds) {
        this.taskIds = taskIds;
    }
}
