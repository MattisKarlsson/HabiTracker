package com.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import com.entities.Habit;
import com.entities.User;
import com.repositories.HabitSqlRepository;
import com.repositories.UserSqlRepository;
import com.requests.AddHabitRequest;
import com.requests.AddUserRequest;
import com.requests.UpdateUserRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UserServiceTest {
    
    private UserService sut;

    private UserSqlRepository userRepo;
    private HabitSqlRepository habitRepo;

    @BeforeEach
    void initTests(){

        this.userRepo = Mockito.mock(UserSqlRepository.class);
        this.habitRepo = Mockito.mock(HabitSqlRepository.class);

        this.sut = new UserService(this.userRepo, this.habitRepo);

    }

    ///////////////////////////////// ADD USER TEST

    @Test
    void UserService_addUser_Success(){
        //Arrange
        when(habitRepo.save(any(Habit.class))).thenAnswer(i -> i.getArguments()[0]);
        when(userRepo.save(any(User.class))).thenAnswer(i -> i.getArguments()[0]);
    
        var addRequest = new AddUserRequest();
        addRequest.setFirstName("McTest");
        addRequest.setLastName("Testings");
        addRequest.setHabits(new ArrayList<AddHabitRequest>());
        
        //Act
        var result = sut.addUser(addRequest);
    
        //Assert
        assertEquals(addRequest.getFirstName(), result.getFirstName());
        assertEquals(addRequest.getLastName(), result.getLastName());
        assertNotNull(result.getCreatedAt());
    }

    

    ///////////////////////////////// UPDATE USER TEST
    
    @Test
    void UserService_updateUser_Success(){
        //Arrange
        var user = new User();
        user.setId(1L);
        user.setFirstName("Test");
        user.setLastName("Testingsson");
        user.setCreatedAt(new Date());
        Optional<User> userMock = Optional.of((User) user);

        when(userRepo.findById(anyLong())).thenReturn(userMock);
        when(userRepo.save(any(User.class))).thenReturn(user);

        var updateRequest = new UpdateUserRequest();
        updateRequest.setFirstName(anyString());
        updateRequest.setLastName("Testingsdottir");

        //Act
        var result = sut.updateUser(1L, updateRequest);

        //Assert
        assertEquals(updateRequest.getLastName(), result.getLastName());
        assertNotNull(result.getCreatedAt());
    }

}




