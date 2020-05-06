package com.example.chat.task.controller;

import com.example.chat.task.model.Project;
import com.example.chat.task.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping
    public ResponseEntity<?>getAll(){
        List<Project> result =  projectService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addOrUpdateProject(@RequestBody Project projectRequest){
        projectService.saveOrUpdateProject(projectRequest);
        return new ResponseEntity<>("Project added", HttpStatus.OK);
    }


}
