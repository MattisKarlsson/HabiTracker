package com.services;

	
	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.Date;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import org.springframework.data.domain.Sort;
	import org.springframework.stereotype.Service;

	import lombok.RequiredArgsConstructor;

	import com.entities.Habit;
	import com.entities.User;
	import com.repositories.HabitSqlRepository;
	import com.repositories.UserSqlRepository;
	import com.requests.AddHabitRequest;
	import com.requests.AddUserRequest;
	import com.requests.UpdateHabitRequest;
	import com.requests.UpdateUserRequest;


	import com.entities.Habit;
	import com.entities.User;
	import com.repositories.HabitSqlRepository;
	import com.repositories.UserSqlRepository;
	import com.requests.AddHabitRequest;
	import com.requests.AddUserRequest;
	import com.requests.UpdateHabitRequest;
	import com.requests.UpdateUserRequest;

	@Service
	@RequiredArgsConstructor
	public class UserService {

		Logger logger = LoggerFactory.getLogger(UserService.class);
		private final UserSqlRepository userRepo;
		private final HabitSqlRepository habitRepo;


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
		
		public Collection<Habit> getHabits() {
			Sort sort = Sort.by(Sort.Direction.ASC, "habitName");
			return habitRepo.findAll(sort);
		}

		public Collection<Habit> getByHabitName(String habitName){
			return habitRepo.findByHabitName(habitName);
		}
		
		public Habit getByHabitId(Long habitId) {
			return habitRepo.findById(habitId).get();
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

			logger.info("Successfully created new Student");
			return user;

		}

		public User updateUser(Long id, UpdateUserRequest request) {
			var user = userRepo.findById(id).get();
			user.setFirstName(request.getFirstName());
			user.setLastName(request.getLastName());
			user = userRepo.save(user);

			logger.info("Updated User");
			return user;
		}

		public void deleteUser(Long id) {
			try {
				userRepo.deleteById(id);
				logger.info("Successfully deleted user with id: " + id); 
			}
			catch(Exception ex) {
				logger.error("Failed to delete user with id: " + id, ex);
			}
			userRepo.deleteById(id);
		}

		public Habit addHabit(AddHabitRequest request) {
			var habit = new Habit();
			habit = habitRepo.save(habit);

			if(request.getHabits().size() > 0) {
				var habits = new ArrayList<Habit>();
				for(AddHabitRequest habitN : request.getHabits()) {
					var newHabit = new Habit();
					newHabit.setHabitName(habitN.getHabitName() != null ? habitN.getHabitName() : "NoName!");
					habits.add(newHabit);
				}
				habitRepo.saveAll(habits);
			}
			return habit;

		}
		public Habit updateHabit(Long habitId, UpdateHabitRequest request) {
			Habit habit = habitRepo.findById(habitId).get();
			habit.setHabitName(request.getHabitName());
			habit = habitRepo.save(habit);

			if(request.getHabits().size() > 0) {
				var habits = new ArrayList<Habit>();
				for(UpdateHabitRequest habitN : request.getHabits()) {
					var newHabit = new Habit();
					newHabit.setHabitName(habitN.getHabitName() != null ? habitN.getHabitName() : "NoName!");
					habits.add(newHabit);
				}
				habitRepo.saveAll(habits);
			}

			logger.info("Updated Habit");
			return habit;
		}


		public void deleteHabit(Long habitId) {
			try {
				habitRepo.deleteById(habitId);
				logger.info("Successfully deleted habit with id: " + habitId); 
			}
			catch(Exception ex) {
				logger.error("Failed to delete habit with id: " + habitId, ex);
			}
			userRepo.deleteById(habitId);

		}

	}

