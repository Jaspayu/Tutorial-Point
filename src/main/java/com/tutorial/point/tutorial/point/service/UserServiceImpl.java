package com.tutorial.point.tutorial.point.service;

import com.tutorial.point.tutorial.point.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> fetchAllUser() {
        return null;
    }

    @Override
    public User fetchUserById(String uuid) {
        return null;
    }

    @Override
    public User fetchUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> fetchUsersByCourse(String course) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }
}
