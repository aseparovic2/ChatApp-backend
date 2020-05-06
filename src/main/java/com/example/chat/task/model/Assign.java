package com.example.chat.task.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "assign")
public class Assign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name="project_id")
    private List<Project> project;

    @OneToMany
    @JoinColumn(name = "task_id")
    private List<Task> tasks;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<User> User;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<User> getUser() {
        return User;
    }

    public void setUser(List<User> user) {
        User = user;
    }
}
