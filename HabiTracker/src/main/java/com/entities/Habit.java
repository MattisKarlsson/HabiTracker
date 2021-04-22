package com.entities;

import java.util.Date;
import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "This is the habit model.")
public class Habit {

	@ApiModelProperty(notes = "Unique identifier for the habit.")
	private UUID id;
	
	@ApiModelProperty(notes = "Name of the tracked habit.")
	private String habitName;
	
	@ApiModelProperty(notes = "Time spent on each tracked habit/task.")
	private double habitDuration;
	
	@ApiModelProperty(notes = "Date and time habit/task was created at.")
	private Date createdAt;
	
	@ApiModelProperty(notes = "Date and time habit/task was updated.")

	private Date updatedAt;


	// Getters & Setters
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	}
