package com.requests;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AddHabitRequest {
    
    @NotBlank(message = "Habit name is mandatory")
    private String habitName;

    @NotBlank(message = "Habit priority is mandatory")
    private int priority;
}
