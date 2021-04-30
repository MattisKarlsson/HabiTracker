package com.entities;

import java.util.Date;
import java.util.UUID;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Activity {
    
    @ApiModelProperty(notes = "Unique identifier for the activity.")
    private UUID id;

    @ApiModelProperty(notes = "Time spent on each tracked habit/task.")
	private int duration;
    
    @ApiModelProperty(notes = "Description of the habit/task.")
	private String description;

    @ApiModelProperty(notes = "Date and time habit/task was created at.")
	private Date createdAt;

    @ApiModelProperty(notes = "Date and time habit/task was updated.")
	private Date updatedAt;

}
