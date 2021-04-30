package com.services;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Activity;
import com.entities.Habit;
import com.repositories.HabitInMemoryRepository;
import com.requests.AddHabitRequest;
import com.requests.UpdateHabitRequest;

@Service
public class HabitService {

	@Autowired
	private HabitInMemoryRepository habitRepo;
	
	
	public Collection<Habit> getAll() {
		return habitRepo.getAll();
	}
	
	public Habit getById(UUID id) {
		return habitRepo.getById(id);
	}

	
	public Habit addHabit(AddHabitRequest request) {
		
		var activity = new Activity();
		activity.setId(UUID.randomUUID());
		activity.setDuration(request.getDuration());
		activity.setDescription(request.getDescription());
		activity.setCreatedAt(new Date());
		activity.setUpdatedAt(new Date());
		
		var habit = new Habit();
		habit.setId(UUID.randomUUID());
		habit.setHabitName(request.getHabitName());
		habit.setCreatedAt(new Date());

		habit.setActivity(activity);
		
		return habitRepo.addHabit(habit);
	}
	
	public Habit updateHabit(UUID id, UpdateHabitRequest request) {		
		var habit = habitRepo.getById(id);		
		habit.setHabitName(request.getHabitName());
		habit.setUpdatedAt(new Date());		
		return habitRepo.updateHabit(id, habit);
	}
	
	public void deleteHabit(UUID id) {
		habitRepo.deleteHabit(id);
	}
}
