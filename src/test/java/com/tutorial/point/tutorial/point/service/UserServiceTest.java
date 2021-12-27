package com.tutorial.point.tutorial.point.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.point.tutorial.point.TutorialPointApplicationTests;
import com.tutorial.point.tutorial.point.domain.User;
import com.tutorial.point.tutorial.point.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest extends TutorialPointApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    @BeforeEach
    void init(){
        saveUser();
    }

    private void saveUser() {
        String userList = "[{\n" +
                "    \"uuid\": \"101\",\n" +
                "    \"email\": \"nick@gmail.com\",\n" +
                "    \"courseEnrolledTo\": [\n" +
                "        \"Core Java\"\n" +
                "    ],\n" +
                "    \"courseInCart\": [],\n" +
                "    \"mobileNumber\": 987654321,\n" +
                "    \"lname\": \"Jonas\",\n" +
                "    \"fname\": \"Nick\"\n" +
                "}," +
                "{\n" +
                "    \"uuid\": \"102\",\n" +
                "    \"email\": \"sam@gmail.com\",\n" +
                "    \"courseEnrolledTo\": [\n" +
                "        \"Dot Net\"\n" +
                "    ],\n" +
                "    \"courseInCart\": [],\n" +
                "    \"mobileNumber\": 987654321,\n" +
                "    \"lname\": \"Nohra\",\n" +
                "    \"fname\": \"Sam\"\n" +
                "}," +
                "{\n" +
                "    \"uuid\": \"103\",\n" +
                "    \"email\": \"john@gmail.com\",\n" +
                "    \"courseEnrolledTo\": [\n" +
                "        \"Core Java\"\n" +
                "    ],\n" +
                "    \"courseInCart\": [],\n" +
                "    \"mobileNumber\": 987654321,\n" +
                "    \"lname\": \"Doe\",\n" +
                "    \"fname\": \"John\"\n" +
                "}" +
                "]";
        try {
            User[] users = new ObjectMapper().readValue(userList, User[].class);

            for (User user : users) {
                userRepo.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fetchAllUserTest(){
        List<User> users = userService.fetchAllUser();
        assertEquals(4, users.size());
    }

    @Test
    public void fetchUserByIdTest(){
        User user = userService.fetchUserById("101");
        assertEquals("Nick", user.getFName());
    }

    @Test
    public void fetchUserByEmailTest(){
        User user = userService.fetchUserByEmail("john@gmail.com");
        assertEquals(user.getUuid(),"103" );
    }

    @Test
    public void fetchUsersByCourseTest(){
        List<User> userList = userService.fetchUsersByCourse("Core Java");
        assertEquals(2,userList.size());
    }

    @Test
    public void saveUserTest(){
       User user = User.builder().uuid("104").fName("Muskan").lName("Jasoriya")
               .courseEnrolledTo(List.of("Pyhon")).courseInCart(List.of()).
               mobileNumber("6928435763").build();
       userService.saveUser(user);

       assertEquals(4,userService.fetchAllUser().size());
    }

}
