package org.example.service;

import org.example.entity.BrigadeEntity;
import org.example.entity.TaskEntity;
import org.example.exception.EntityAlreadyExistException;
import org.example.exception.EntityNotFoundException;
import org.example.model.Task;
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
    public List<TaskEntity> getAllTasks() {
        return (List<TaskEntity>) taskRepo.findAll();
    }

    @Override
    public Task createTask(TaskEntity task, Long brigadeId) throws EntityAlreadyExistException {
        if (taskRepo.findByTitle(task.getTitle()).isPresent()) {
            throw new EntityAlreadyExistException("Задача с таким именем уже существует");
        }
        BrigadeEntity brigade = brigadeRepo.findById(brigadeId).get();
        task.setBrigade(brigade);
        return Task.toModel(taskRepo.save(task));
    }

    @Override
    public Task getTask(Long id) throws EntityNotFoundException {
        return Task.toModel
                (taskRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Задача не найдена")));

    }

    @Override
    public Task getTask(String title) throws EntityNotFoundException {
        return Task.toModel(taskRepo.findByTitle(title).orElseThrow(() -> new EntityNotFoundException("Задача не найдена")));
    }

    @Override
    public String deleteTask(Long id) throws EntityNotFoundException {
        TaskEntity task = taskRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Задача не найдена"));
        String nameTask = task.getTitle();
        taskRepo.deleteById(id);
        return "Задача " + nameTask + " удалена.";
    }

    @Override
    public TaskEntity updateTask(TaskEntity task, Long id) throws EntityNotFoundException {

        return taskRepo.findById(id).map(oldTask -> {
            oldTask.setTitle(task.getTitle());
            oldTask.setDescription(task.getDescription());
            return taskRepo.save(oldTask);
        }).orElseThrow(() -> new EntityNotFoundException("Задача не найдена"));
    }



}
