package com.example.chat.task.service;

import com.example.chat.task.model.Project;
import com.example.chat.task.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    List<Project> findAll();

    List<Project> findByName(Project project);

    void saveOrUpdateProject(Project project);


}
