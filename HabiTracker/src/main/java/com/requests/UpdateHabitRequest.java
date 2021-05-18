package com.requests;

import java.util.List;

import lombok.Data;

@Data
public class UpdateHabitRequest {
  
    private String habitName;
    private int priority;

    private List<UpdateHabitRequest> habits;
}
