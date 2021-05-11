package com.entities;

import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Add new user request model.")
@Entity
@Getter
@Setter
@Table(name = "AppUser")

	public class User {

	@ApiModelProperty(notes = "Unique identifier for the user.")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ApiModelProperty(notes = "first name of the user.")
	@Column(name = "first_name")
	private String firstName;
	
	@ApiModelProperty(notes = "last name of the user.")
	@Column(name = "last_name")
	private String lastName;
	
	@ApiModelProperty(notes = "Date and time user was created at.")
	@Column(name = "created_at")
	private Date createdAt;
	
	@ApiModelProperty(notes = "Date and time user was updated.")
	@Column(name = "updated_at")
	private Date updatedAt;
}
