package com.requests;

import lombok.Data;

@Data
public class UpdateUserRequest {
	private String firstName;
	private String lastName;

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	}

