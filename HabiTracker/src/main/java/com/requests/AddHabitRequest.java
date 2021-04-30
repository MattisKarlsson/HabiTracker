package com.requests;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Add new habit request")
@Getter
@Setter
public class AddHabitRequest {

	@ApiModelProperty(notes = "Name of the habit to track")
	private String habitName;

	@ApiModelProperty(notes = "Priority of the task")
	private String priority;
	
	@ApiModelProperty(notes = "Duration of your tracked habit")
	private int duration;

	@ApiModelProperty(notes = "Description of the habit/task.")
	private String description;

}
