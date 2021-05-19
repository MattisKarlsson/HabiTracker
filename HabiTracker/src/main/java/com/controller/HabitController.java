package com.controller;

import java.util.Collection;

import javax.validation.Valid;

import com.entities.Habit;
import com.requests.AddHabitRequest;
import com.requests.UpdateHabitRequest;
import com.services.UserService;

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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/habits/")
public class HabitController {
    
    Logger logger = LoggerFactory.getLogger(HabitController.class);
	
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
			value = "Get all Habits",notes = "Fetches all habits from the API",response = Habit.class,responseContainer = "List")		
	public Collection<Habit> getAll() {
		return userService.getHabits();
	}

	@GetMapping("/{habitId}")
	@ApiOperation(value = "Get habit by ID",notes = "Fetches habit with specific ID",response = Habit.class)				
	public Habit getByHabitId(@ApiParam(value = "ID of the habit", required = true)
			@PathVariable Long habitId) {
		Habit response = userService.getByHabitId(habitId);
		
		if (response == null) {
			logger.warn("Couldn't find habit by this HabitId: " + habitId);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldnt find any habit with provided ID");
		}
		return response;
	}

	@GetMapping("/name/{habitName}")
	public Collection<Habit> getByHabitName(@PathVariable String habitName) {
		return userService.getByHabitName(habitName);
	}

	@PostMapping("/")
	public Habit addNewHabit(@Valid @RequestBody AddHabitRequest request) {
		return userService.addHabit(request);
		
	}
	
	@PutMapping("/{habitId}")
	@ApiOperation(value = "Update habit",notes = "Update habit name",response = Habit.class)
	public Habit updateHabit(@PathVariable Long habitId, @RequestBody UpdateHabitRequest request) {
		return userService.updateHabit(habitId, request);
	}
	
	@DeleteMapping("/{habitId}")
	@ApiOperation(value = "Delete habit",notes = "Deletes specified habit.",response = Habit.class)
	public void deleteHabit(@PathVariable Long habitId) {
		userService.deleteHabit(habitId);
	}

}
