package com.requests;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Add new habit request")

public class AddHabitRequest {

	@ApiModelProperty(notes = "Name of the habit to track")
	private String habitName;
	
	@ApiModelProperty(notes = "Duration of your tracked habit")
	private double habitDuration;
	

	public String getHabitName() {
		return habitName;
	}
	public void setHabitName(String habitName) {
		this.habitName = habitName;
	}
	public double getHabitDuration() {
		return habitDuration;
	}
	public void setHabitDuration(double habitDuration) {
		this.habitDuration = habitDuration;
	}
	
}
