package com.repositories;

import com.entities.Habit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitSqlRepository extends JpaRepository<Habit, Long>{
    
}
