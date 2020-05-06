package com.example.chat.task.payload;

import com.example.chat.task.model.Status;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaskRequest {
    @NotBlank
    @Size(min=4,max = 30)
    private String name;

    @NotBlank
    @Size(min=50,max=1000)
    private String description;

    @NotBlank
    private Status status;


    private TaskLength taskLength;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TaskLength getTaskLength() {
        return taskLength;
    }

    public void setTaskLength(TaskLength taskLength) {
        this.taskLength = taskLength;
    }
}
