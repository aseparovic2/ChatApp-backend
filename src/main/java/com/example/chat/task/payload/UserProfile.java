package com.example.chat.task.payload;

import java.time.Instant;

public class UserProfile {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private Instant joinedAt;
    private int tasksAssignedTo;
    private int tasksFinished;

    public UserProfile(Long id, String username, String firstName, String lastName, Instant joinedAt, int tasksAssignedTo, int tasksFinished) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinedAt = joinedAt;
        this.tasksAssignedTo = tasksAssignedTo;
        this.tasksFinished = tasksFinished;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Instant getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(Instant joinedAt) {
        this.joinedAt = joinedAt;
    }

    public int getTasksAssignedTo() {
        return tasksAssignedTo;
    }

    public void setTasksAssignedTo(int tasksAssignedTo) {
        this.tasksAssignedTo = tasksAssignedTo;
    }

    public int getTasksFinished() {
        return tasksFinished;
    }

    public void setTasksFinished(int tasksFinished) {
        this.tasksFinished = tasksFinished;
    }
}
