package com.services;

	
	import java.util.Collection;
	import java.util.Date;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.domain.Sort;
	import org.springframework.stereotype.Service;

import com.entities.User;
import com.entities.Activity;
import com.repositories.UserSqlRepository;
import com.requests.AddUserRequest;
import com.requests.UpdateUserRequest;


	@Service
	public class UserService {

		@Autowired
		private UserSqlRepository userRepo;

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

			// var courses = new ArrayList<Course>();

			// if (request.getCourses().size() > 0) {
			// 	for (Course course : request.getCourses()) {
			// 		var newCourse = new Course();
			// 		newCourse.setName(course.getName() != null ? course.getName() : "NoName!");
			// 		courses.add(newCourse);
			// 	}
			// }

			// var address = new Address();
			// address.setCity(request.getCity());
			// address.setStreet(request.getStreet());

			var user = new User();
			user.setFirstName(request.getFirstName());
			user.setLastName(request.getLastName());
			user.setCreatedAt(new Date());

			//user.setAddress(address);

			//user.setCourses(courses);

			return userRepo.save(user);
		}

		public User updateUser(Long id, UpdateUserRequest request) {
			var user = userRepo.findById(id).get();
			user.setLastName(request.getLastName());
			user.setUpdatedAt(new Date());
			return userRepo.save(user);
		}

		public void deleteUser(Long Id) {
			userRepo.deleteById(Id);
		}

	}

