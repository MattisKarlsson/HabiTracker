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

@RestController
@RequestMapping("/api/habits/")
public class HabitsController {

	@Autowired
	private HabitService habitService;
	
	
	@GetMapping("/")
	public Collection<Habit> getAll() {
		return habitService.getAll();
	}
	
	@GetMapping("/{id}")
	public Habit getById(@PathVariable UUID id) {
		return habitService.getById(id);
	}
	
	@PostMapping("/")
	public Habit addNewHabit(@RequestBody AddHabitRequest request) {
		return habitService.addHabit(request);
	}
	
	@PutMapping("/{id}")
	public Habit updateHabit(@PathVariable UUID id, @RequestBody UpdateHabitRequest request) {
		return habitService.updateHabit(id, request);
	}
	
	@DeleteMapping("/{id}")
	public void deleteHabit(@PathVariable UUID id) {
		habitService.deleteHabit(id);
	}
}
