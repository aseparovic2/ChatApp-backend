package com.example.chat.task.payload;

import javax.validation.constraints.NotBlank;

public class ProjectRequest {
    @NotBlank
    private String name;
}
