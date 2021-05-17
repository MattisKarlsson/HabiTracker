package com.repositories;

import com.entities.Activity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivitySqlRepository extends JpaRepository<Activity, Long> {
    
}
