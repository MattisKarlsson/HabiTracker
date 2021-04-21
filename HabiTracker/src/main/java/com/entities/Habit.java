package com.entities;

import java.util.Date;
import java.util.UUID;

public class Habit {

	private UUID id;
	private String habitName;
	private double habitDuration;
	private Date createdAt;
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
