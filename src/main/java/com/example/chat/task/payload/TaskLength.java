package com.example.chat.task.payload;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class TaskLength {
    @NotNull
    @Max(31)
    private int month;

    @NotNull
    @Max(7)
    private int day;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
