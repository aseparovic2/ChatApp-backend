package com.example.chat.task.payload;

public class UserIdentiyAvailability {
    private boolean available;

    public UserIdentiyAvailability(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
