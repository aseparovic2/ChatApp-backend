package com.example.chat.task.service;


import com.example.chat.task.model.Task;
import com.example.chat.task.model.User;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface TaskService {

    List<Task> findAll();

    List<Task> findByName(User name);

    void saveOrUpdateTask(Task task);

    public void deleteTask(Long id);

    }


