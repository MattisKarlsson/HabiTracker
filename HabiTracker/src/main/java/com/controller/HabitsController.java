package com.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entities.*;

@RestController
@RequestMapping("/api/habits/")
public class HabitsController {

	
	Map<Integer, Habit> habits = new HashMap<Integer, Habit>();
	
	@GetMapping("/")
	public Collection<Habit> getAll() {
		return habits.values();
	}
	
	@GetMapping("/{id}")
	public Habit getById(@PathVariable int id) {
		return habits.get(id);
	}
	
	@PostMapping("/")
	public Habit addNewHabit(@RequestBody Habit habit) {
		habits.put(habit.getId(), habit);
		return habit;
	}
	
	@PutMapping("/{id}")
	public Habit updateHabit(@PathVariable int id, @RequestBody Habit updatedHabit) {
		
		Habit habit = habits.get(id);
		habit.setHabitName(updatedHabit.getHabitName());
		habit.setHabitDuration(updatedHabit.getHabitDuration());
		return habit;
	}
	
	@DeleteMapping("/{id}")
	public void deleteHabit(@PathVariable int id) {
		habits.remove(id);
	}
}
