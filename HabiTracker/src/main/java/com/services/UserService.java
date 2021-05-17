package com.services;

	
	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.Date;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.domain.Sort;
	import org.springframework.stereotype.Service;

import com.entities.Activity;
import com.entities.Habit;
import com.entities.User;
import com.repositories.ActivitySqlRepository;
import com.repositories.HabitSqlRepository;
import com.repositories.UserSqlRepository;
import com.requests.AddHabitRequest;
import com.requests.AddUserRequest;
import com.requests.UpdateUserRequest;


	@Service
	public class UserService {

		@Autowired
		private UserSqlRepository userRepo;

		@Autowired
		private ActivitySqlRepository activityRepo;

		@Autowired
		private HabitSqlRepository habitRepo;

		public Collection<User> getAll() {
			Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
			return userRepo.findAll(sort);
		}

		public User getById(Long id) {
			return userRepo.findById(id).get();
		}

		public Collection<User> getByFirstName(String firstName){
			return userRepo.findByFirstName(firstName);
		}
		public Collection<User> getByLastName(String lastName){
			return userRepo.findByLastName(lastName);
		}

		public User addUser(AddUserRequest request) {

			var user = new User();
			user.setFirstName(request.getFirstName());
			user.setLastName(request.getLastName());
			user.setCreatedAt(new Date());
			user = userRepo.save(user);
			
			
			if(request.getHabits().size() > 0) {
				var habits = new ArrayList<Habit>();
				for(AddHabitRequest habit : request.getHabits()) {
					var newHabit = new Habit();
					newHabit.setHabitName(habit.getHabitName() != null ? habit.getHabitName() : "NoName!");
					newHabit.setUser(user);
					habits.add(newHabit);
				}
				habitRepo.saveAll(habits);
				user.setHabits(habits);
			}

			return user;

		}

		public User updateUser(Long id, UpdateUserRequest request) {
			var user = userRepo.findById(id).get();
			user.setLastName(request.getLastName());
			return userRepo.save(user);
		}

		public void deleteUser(Long Id) {
			userRepo.deleteById(Id);
		}

	}

