package com.tutorial.point.tutorial.point.service;

import com.tutorial.point.tutorial.point.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> fetchAllUser();
    User fetchUserById(String uuid);
    User fetchUserByEmail(String email);
    List<User> fetchUsersByCourse(String course);
    String saveUser(User user);
}
