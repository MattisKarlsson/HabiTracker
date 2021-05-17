package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "app_activity")
@ApiModel(description = "Add new activity request model.")
public class Activity {

	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Activity ID.")
    @Column(name = "id")
	private Long id;
    
    @ApiModelProperty(notes = "Time spent on each tracked habit/task.")
    @Column(name = "duration")
	private int duration;
    
    @ApiModelProperty(notes = "Description of the habit/task.")
    @Column(name = "description")
	private String description;

    @JsonIgnore
    @ManyToOne 
    @JoinColumn(name = "habit_id")
    private Habit habit; 
}
