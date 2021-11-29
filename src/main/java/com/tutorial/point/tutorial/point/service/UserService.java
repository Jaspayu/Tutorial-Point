package com.tutorial.point.tutorial.point.service;

import com.tutorial.point.tutorial.point.domain.User;
import java.util.List;


public interface UserService {
    List<User> fetchAllUser();
    User fetchUserById(String uuid);
    User fetchUserByEmail(String email);
    List<User> fetchUsersByCourse(String course);
    void saveUser(User user);
}
