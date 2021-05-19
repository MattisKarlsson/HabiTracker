package com.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.entities.Habit;

public class HabitInMemoryRepository {
    
    Map<Long, Habit> habits = new HashMap<Long, Habit>();
	
	public Collection<Habit> getHabits() {
		return habits.values();
	}
	
	public Habit getByHabitId(Long habitId) {
		return habits.get(habitId);
	}

    public Habit addHabit(Habit habit) {
		habits.put(habit.getHabitId(), habit);
		return habits.get(habit.getHabitId());
	}
	
	public Habit updateHabit(Long habitId, Habit habit) {
		habits.put(habitId, habit);
		return habits.get(habitId);
	}
	
	public void deleteHabit(Long habitId) {
		habits.remove(habitId);
	}
}
