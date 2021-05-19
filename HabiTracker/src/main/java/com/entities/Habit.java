package com.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Add new habit request model.")
@Data
@Entity
@Table(name = "app_habit")
public class Habit {
    
    @ApiModelProperty(notes = "Unique identifier for the habit.")
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long habitId;

    @ApiModelProperty(notes = "Habit name.")
    @Column(name = "habit_name")
    private String habitName;

    @ApiModelProperty(notes = "Priority of habit.")
    @Column(name = "habit_priority")
    private int priority;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @JsonIgnore
    @OneToMany (mappedBy = "habit")
    private List <Activity> activities;
}
