package com.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ch.qos.logback.core.subst.Token.Type;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Add new user request model.")
@Entity
@Data
@Table(name = "app_user")

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

	// OneToMany
	@OneToMany (mappedBy = "user", fetch = FetchType.EAGER)
	private List <Habit> habits;
	
}
