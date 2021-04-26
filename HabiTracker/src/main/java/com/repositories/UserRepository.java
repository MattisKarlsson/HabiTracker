package com.repositories;

public class UserRepository {

	interface UserRepository extends CrudRepository<User, Long> {

		Optional<User> loadByUsername(String username);
		Optional<User> findByUsername(String username);
	
}
}
