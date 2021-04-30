package com.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateHabitRequest {

	private String habitName;
	private int habitDuration;
	
}
