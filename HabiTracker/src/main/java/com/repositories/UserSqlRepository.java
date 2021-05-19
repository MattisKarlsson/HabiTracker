package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.User;

import java.util.List;

@Repository
public interface UserSqlRepository extends JpaRepository<User, Long> {
	// JPA repository is the same as CrudRepository and PagingAndSortingRepository together.
	
	  List<User> findByFirstName(String firstName);
	  
	  List<User> findByLastName(String lastName);

	    List<User> findByFirstNameAndLastName(String firstName, String lastName);

	    List<User> findByFirstNameOrLastName(String firstName, String lastName);

}
