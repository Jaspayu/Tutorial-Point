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
    @GetMapping("user-service/fetchAllUsers/{id}")
    public User getUserDetailsById(@PathVariable String uuid){
        return userService.fetchUserById(uuid);
    }

    @GetMapping("user-service/fetchAllUsers/{email}")
    public User getUserDetailsByEmail(@PathVariable String email){
        return userService.fetchUserByEmail(email);
    }

    @PostMapping("user-service/saveUser")
    public String registerUser(@RequestBody User user){
        userService.saveUser(user);
        return("user saved successfully");
    }
    @GetMapping("hello")
    public String hellow(){
        return("Hello User!!");
    }
}
