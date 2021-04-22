package com.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entities.*;

import com.requests.AddHabitRequest;
import com.requests.UpdateHabitRequest;
import com.services.HabitService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/api/habits/")
public class HabitsController {

	@Autowired
	private HabitService habitService;
	
	
	@GetMapping("/")
	@ApiOperation(
			value = "Get all Habits", 
			notes = "Fetches all habits from the API",
			response = Habit.class,
			responseContainer = "List")		
	public Collection<Habit> getAll() {
		return habitService.getAll();
	}
	
	
	@GetMapping("/{id}")
	@ApiOperation(
			value = "Get habit by ID",
			notes = "Fetches habit with specific ID",
			response = Habit.class)				
	public Habit getById(
			@ApiParam(value = "ID of the Habit", required = false)
			@PathVariable UUID id) {
		return habitService.getById(id);
	}
	
	@PostMapping("/")
	@ApiOperation(
			value = "Add new habit",
			notes = "Add a new habit to your tracker",
			response = Habit.class)
	public Habit addNewHabit(@RequestBody AddHabitRequest request) {
		return habitService.addHabit(request);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(
			value = "Update habit",
			notes = "Update habit name and/or duration. Once task completed it will be moved to \"Done\"",
			response = Habit.class)
	public Habit updateHabit(@PathVariable UUID id, @RequestBody UpdateHabitRequest request) {
		return habitService.updateHabit(id, request);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(
			value = "Delete habit",
			notes = "Deletes specified habit/task.",
			response = Habit.class)
	public void deleteHabit(@PathVariable UUID id) {
		habitService.deleteHabit(id);
	}
}
