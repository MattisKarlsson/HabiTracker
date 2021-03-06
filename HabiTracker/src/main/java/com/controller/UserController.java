package com.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.entities.User;
import com.requests.AddUserRequest;
import com.requests.UpdateUserRequest;
import com.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);

	private final UserService userService;

	@GetMapping("/log")
	public String testLogging(){

		logger.trace("TRACE Logging");
		logger.debug("DEBUG Logging");
		logger.info("INFO Logging");
		logger.warn("WARN Logging");
		logger.error("ERROR Logging");

		return "Logging successful";
	}

	@GetMapping("/")
	@ApiOperation(
			value = "Get all Users",notes = "Fetches all users from the API",response = User.class,responseContainer = "List")		
	public Collection<User> getAll() {
		return userService.getAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get user by ID",notes = "Fetches user with specific ID",response = User.class)				
	public User getById(@ApiParam(value = "ID of the User", required = true)
			@PathVariable Long id) {
		var response = userService.getById(id);
		
		if (response == null) {
			logger.warn("Couldn't find user by this id: " + id);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldnt find any user with provided ID");
		}
		return response;
	}

	@GetMapping("/name/{firstName}")
	public Collection<User> getByFirstName(@PathVariable String firstName) {
		return userService.getByFirstName(firstName);
	}
	@GetMapping("/name/{lastName}")
	public Collection<User> getByLastName(@PathVariable String lastName) {
		return userService.getByLastName(lastName);
	}
	
	@PostMapping("/")
	public User addNewUser(@Valid @RequestBody AddUserRequest request) {
		return userService.addUser(request);
		
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Update user",notes = "Update user name",response = User.class)
	public User updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
		return userService.updateUser(id, request);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete user",notes = "Deletes specified user.",response = User.class)
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}

