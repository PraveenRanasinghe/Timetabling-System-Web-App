package com.timetabling.demo.repositary;

import com.timetabling.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    User findUserByEmail(String email);

    @Query("FROM User u WHERE u.fName LIKE %:firstName%")
    List<User> firstName(String firstName);


    @Query("FROM User u WHERE u.lName LIKE %:lastName%")
    List<User> lastName(String lastName);

}

