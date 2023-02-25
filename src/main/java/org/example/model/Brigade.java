package org.example.model;

import org.example.entity.BrigadeEntity;
import java.util.List;
import java.util.stream.Collectors;

public class Brigade {
    private Long id;
    private String title;
    private String description;
    private List<Task> taskIds;

    public static Brigade toModel(BrigadeEntity brigadeEntity) {
        Brigade model = new Brigade();
        model.setId(brigadeEntity.getId());
        model.setTitle(brigadeEntity.getTitle());
        model.setDescription(brigadeEntity.getDescription());
        model.setTaskIds(brigadeEntity.getTaskIds().stream().map(Task::toModel).collect(Collectors.toList()));
        return model;
    }


    public Brigade() {
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
