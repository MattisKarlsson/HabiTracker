package com.entities;

public class Habit {
	
	public Habit() {

	}

	public Habit(int id, String habitName, double habitDuration) {
		this.id = id;
		this.habitName = habitName;
		this.habitDuration = habitDuration;
	}

	private int id;
	private String habitName;
	private double habitDuration;

	
	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
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


	}
