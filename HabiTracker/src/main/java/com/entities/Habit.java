package com.entities;

import java.util.Date;
import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "This is the habit model.")
public class Habit {

	@ApiModelProperty(notes = "Unique identifier for the habit.")
	private UUID id;
	
	@ApiModelProperty(notes = "Name of the tracked habit.")
	private String habitName;

	@ApiModelProperty(notes = "Priority of the habit.")
	private int priority;
	
	@ApiModelProperty(notes = "Date and time habit/task was created at.")
	private Date createdAt;

	@ApiModelProperty(notes = "Date and time habit/task was updated.")
	private Date updatedAt;

	private Activity activity;

	}
