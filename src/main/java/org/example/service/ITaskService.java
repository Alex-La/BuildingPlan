package org.example.service;

import org.example.entity.TaskEntity;
import org.example.exception.EntityAlreadyExistException;
import org.example.exception.EntityNotFoundException;
import org.example.model.Task;

import java.util.List;

public interface ITaskService {

    List<TaskEntity> getAllTasks();

    Task createTask(TaskEntity task, Long brigadeId) throws EntityAlreadyExistException;

    Task getTask(Long id) throws EntityNotFoundException;

    Task getTask(String title) throws EntityNotFoundException;

    String deleteTask(Long id) throws EntityNotFoundException;

    TaskEntity updateTask(TaskEntity task, Long id) throws EntityNotFoundException;
}
