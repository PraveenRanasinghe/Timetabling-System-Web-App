package com.timetabling.demo.service;

import com.timetabling.demo.dto.UserDTO;
import com.timetabling.demo.model.ClassRoom;
import com.timetabling.demo.model.User;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import org.hamcrest.collection.IsEmptyCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void getAllUsers(){
        List<User> allLecturers = userService.getAllUsers();
        assertThat(allLecturers, not(IsEmptyCollection.empty()));
    }

    @Test
    public void getAllStudents(){
        List<UserDTO> allStudents = userService.getAllStudents();
        assertThat(allStudents,not(IsEmptyCollection.empty()));
    }

    @Test
    public void getAllLecturers(){
        List<UserDTO> allLecturers = userService.getAllLecturers();
        assertThat(allLecturers,not(IsEmptyCollection.empty()));
    }

}