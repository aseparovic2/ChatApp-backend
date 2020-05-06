package com.example.chat.task.controller;

import com.example.chat.task.model.Task;

import com.example.chat.task.security.CurrentUser;
import com.example.chat.task.security.UserPrincipal;
import com.example.chat.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public ResponseEntity<?>getAll(){
        List<Task> result = taskService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


  @PostMapping
  @PreAuthorize("hasRole('USER')")
  public ResponseEntity<?>addOrUpdateTask(@CurrentUser UserPrincipal userPrincipal,
            @RequestBody Task taskRequest){
      taskService.saveOrUpdateTask(taskRequest);
      return new ResponseEntity<>("Task addedd", HttpStatus.OK);
  }


    @DeleteMapping
    public void deleteTask(@RequestParam("id") Long id){
      taskService.deleteTask(id);
    }
}



//}

