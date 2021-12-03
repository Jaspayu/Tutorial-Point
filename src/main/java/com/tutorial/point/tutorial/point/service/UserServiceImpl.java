package com.tutorial.point.tutorial.point.service;

import com.tutorial.point.tutorial.point.domain.User;
import com.tutorial.point.tutorial.point.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public List<User> fetchAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User fetchUserById(String uuid) {
        Optional<User> user = userRepo.findById(uuid);
        if(user.isPresent()){
            return user.get();
        }else {
            return null;
        }
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
