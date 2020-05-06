package com.example.chat.task.controller;

import com.example.chat.task.exception.ResourceNotFoundException;
import com.example.chat.task.model.User;
import com.example.chat.task.payload.UserIdentiyAvailability;
import com.example.chat.task.payload.UserProfile;
import com.example.chat.task.payload.UserSummary;
import com.example.chat.task.repository.TaskRepository;
import com.example.chat.task.repository.UserRepository;
import com.example.chat.task.security.CurrentUser;
import com.example.chat.task.security.UserPrincipal;
import com.example.chat.task.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser){
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getFirstName());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentiyAvailability checkUsernameAvailability(@RequestParam(value = "username")String username){
        boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentiyAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentiyAvailability checkEmailAvailability(@RequestParam(value = "email")String email){
        boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentiyAvailability(isAvailable);
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username")String username){
        User user = userRepository.findByUsername(username).orElseThrow(()->
                new ResourceNotFoundException("User","username", username));
        int tasks=0;
        int joined=0;
        UserProfile userProfile = new UserProfile(user.getUserID(),user.getUsername(),user.getFirstName(), user.getLastName(), user.getCreatedAt(),joined,tasks);
        return userProfile;//todo fix userprofile ;
    }
}
