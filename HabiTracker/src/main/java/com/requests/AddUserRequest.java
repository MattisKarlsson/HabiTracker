package com.requests;
import java.util.List;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(description = "Add new user request")
@Data
public class AddUserRequest {
	
	@ApiModelProperty(notes = "The FirstName of the User")
	@NotBlank(message = "FirstName is mandatory")
	private String firstName;

	@ApiModelProperty(notes = "The LastName of the User")
	@NotBlank(message = "LastName is mandatory")
	private String lastName;

	private int duration;
	private String description;

	private List<AddHabitRequest> habits;
	
}
