package com.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.entities.Habit;

@Service
public class HabitInMemoryRepository {


	Map<UUID, Habit> habits = new HashMap<UUID, Habit>();
	
	public Collection<Habit> getAll() {
		return habits.values();
	}
	
	public Habit getById(UUID id) {
		return habits.get(id);
	}
	
	public Habit addHabit(Habit habit) {
		habits.put(habit.getId(), habit);
		return habits.get(habit.getId());
	}
	
	public Habit updateHabit(UUID id, Habit habit) {
		habits.put(id, habit);
		return habits.get(id);
	}
	
	public void deleteHabit(UUID id) {
		habits.remove(id);
	}
}
