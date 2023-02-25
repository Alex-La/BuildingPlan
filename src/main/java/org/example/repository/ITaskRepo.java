package org.example.repository;

import org.example.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ITaskRepo extends CrudRepository<TaskEntity, Long> {
    Optional<TaskEntity> findByTitle(String title);
}
