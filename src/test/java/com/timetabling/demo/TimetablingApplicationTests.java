package com.timetabling.demo;

import com.timetabling.demo.model.User;
import com.timetabling.demo.repositary.UserRepo;
import com.timetabling.demo.service.UserService;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TimetablingApplicationTests {

    @Test
    void contextLoads() {
        assertEquals(2+2,4);

    }



}
