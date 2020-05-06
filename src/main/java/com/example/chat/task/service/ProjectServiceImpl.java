package com.example.chat.task.service;

import com.example.chat.task.model.Project;
import com.example.chat.task.model.User;
import com.example.chat.task.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements  ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Project> findAll(){
        return projectRepository.findAll();
    };

    @Override
    public List<Project> findByName(Project project){
    return  projectRepository.findByName(project);
    }

    @Override
    public void saveOrUpdateProject(Project project){
        projectRepository.save(project);
    };

}
