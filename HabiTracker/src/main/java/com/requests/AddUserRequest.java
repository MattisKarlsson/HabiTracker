package com.requests;
import java.util.List;
import javax.validation.constraints.NotBlank;

import com.entities.Activity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(description = "Add new user request")
@Getter
@Setter
public class AddUserRequest {

	
	@ApiModelProperty(notes = "The FirstName of the User")
	@NotBlank(message = "FirstName is mandatory")
	private String firstName;

	@ApiModelProperty(notes = "The LastName of the User")
	@NotBlank(message = "LastName is mandatory")
	private String lastName;

	private String city;
	private String street;

	private List<Activity> activities;
	
}
