package com.example.chat.task.service;

import com.example.chat.task.model.Task;
import com.example.chat.task.model.User;
import com.example.chat.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findByName(User name){
        return taskRepository.findByNameOrderByDateDesc(name);
    }

    @Override
    public void saveOrUpdateTask(Task task){
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
