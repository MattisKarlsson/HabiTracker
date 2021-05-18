package com.requests;


import java.util.List;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Add new habit request")
@Data
public class AddHabitRequest {

    @ApiModelProperty(notes = "The name of the habit")
    @NotBlank(message = "Habit name is mandatory")
    private String habitName;

    @ApiModelProperty(notes = "The priority of the habit")
    @NotBlank(message = "Habit priority is mandatory")
    private int priority;

    private List<AddHabitRequest> habits;
}
