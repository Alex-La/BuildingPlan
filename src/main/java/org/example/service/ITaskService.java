package org.example.service;

import org.example.entity.Task;
import org.example.exception.EntityAlreadyExistException;
import org.example.exception.EntityNotFoundException;

import java.util.List;

public interface ITaskService {

    List<Task> getAllTasks();

    Task createTask(Task task, Long brigadeId) throws EntityAlreadyExistException;

    Task getTask(Long id) throws EntityNotFoundException;

    Task getTask(String title) throws EntityNotFoundException;

    String deleteTask(Long id) throws EntityNotFoundException;

    Task updateTask(Task task, Long id) throws EntityNotFoundException;
}
