package org.example.service;

import org.example.entity.Brigade;
import org.example.entity.Task;
import org.example.exception.EntityAlreadyExistException;
import org.example.exception.EntityNotFoundException;
import org.example.repository.IBrigadeRepo;
import org.example.repository.ITaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private ITaskRepo taskRepo;
    @Autowired
    private IBrigadeRepo brigadeRepo;

    @Override
    public List<Task> getAllTasks() {
        return (List<Task>) taskRepo.findAll();
    }

    @Override
    public Task createTask(Task task, Long brigadeId) throws EntityAlreadyExistException {
        if (taskRepo.findByTitle(task.getTitle()).isPresent()) {
            throw new EntityAlreadyExistException("Задача с таким именем уже существует");
        }
        Brigade brigade = brigadeRepo.findById(brigadeId).get();
        task.setBrigade(brigade);
        return taskRepo.save(task);
    }

    @Override
    public Task getTask(Long id) throws EntityNotFoundException {
        return taskRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Задача не найдена"));

    }

    @Override
    public Task getTask(String title) throws EntityNotFoundException {
        return taskRepo.findByTitle(title).orElseThrow(() -> new EntityNotFoundException("Задача не найдена"));
    }

    @Override
    public String deleteTask(Long id) throws EntityNotFoundException {
        Task task = taskRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Задача не найдена"));
        String nameTask = task.getTitle();
        taskRepo.deleteById(id);
        return "Задача " + nameTask + " удалена.";
    }

    @Override
    public Task updateTask(Task task, Long id) throws EntityNotFoundException {

        return taskRepo.findById(id).map(oldTask -> {
            oldTask.setTitle(task.getTitle());
            oldTask.setDescription(task.getDescription());
            return taskRepo.save(oldTask);
        }).orElseThrow(() -> new EntityNotFoundException("Задача не найдена"));
    }



}
