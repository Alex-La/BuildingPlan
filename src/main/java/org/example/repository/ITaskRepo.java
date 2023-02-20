package org.example.repository;

import org.example.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ITaskRepo extends CrudRepository<Task, Long> {
    Optional<Task> findByTitle(String title);
}
