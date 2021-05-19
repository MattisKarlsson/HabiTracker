package com.repositories;

import java.util.List;

import com.entities.Habit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitSqlRepository extends JpaRepository<Habit, Long>{
    
    List<Habit> findByHabitName(String habitName);
	  
}
