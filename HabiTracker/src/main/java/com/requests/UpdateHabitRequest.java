package com.requests;

public class UpdateHabitRequest {

	private String habitName;
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
