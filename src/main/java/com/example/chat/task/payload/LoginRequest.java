package com.example.chat.task.payload;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank
    private String usernamOrEmail;

    @NotBlank
    private String password;

    public String getUsernamOrEmail() {
        return usernamOrEmail;
    }

    public void setUsernamOrEmail(String usernamOrEmail) {
        this.usernamOrEmail = usernamOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
