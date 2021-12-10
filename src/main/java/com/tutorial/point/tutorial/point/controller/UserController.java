package com.tutorial.point.tutorial.point.controller;

import com.tutorial.point.tutorial.point.domain.User;
import com.tutorial.point.tutorial.point.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user-service/fetchAllUsers")
    public List<User> getAllUserDetails(){
        return userService.fetchAllUser();
    }

    @GetMapping("user-service/fetchAllUsers/course/{course}")
    public List<User> getAllUserForCourse( @PathVariable String course){
        return userService.fetchUsersByCourse(course);
    }

    @GetMapping("user-service/fetchAllUsers/id/{id}")
    public User getUserDetailsById(@PathVariable String id){
        return userService.fetchUserById(id);
    }

    @GetMapping("user-service/fetchAllUsers/email/{email}")
    public User getUserDetailsByEmail(@PathVariable String email){
        return userService.fetchUserByEmail(email);
    }

    @PostMapping("user-service/saveUser")
    public String registerUser(@RequestBody User user){
        userService.saveUser(user);
        return("user saved successfully");
    }
    @GetMapping("hello")
    public String hello(){
        return("Hello User!!");
    }
}
