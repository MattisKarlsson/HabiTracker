package com.requests;


import lombok.Data;

@Data
public class UpdateHabitRequest {
  
    private String habitName;
    private int priority;

}
