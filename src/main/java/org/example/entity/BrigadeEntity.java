package org.example.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brigades")
public class BrigadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "brigade", cascade = CascadeType.ALL)
    private List<TaskEntity> taskIds = new ArrayList<>();

    public BrigadeEntity() {
    }

    public BrigadeEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public BrigadeEntity(String title, String description, List<TaskEntity> taskIds) {
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

    public List<TaskEntity> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<TaskEntity> taskIds) {
        this.taskIds = taskIds;
    }
}
