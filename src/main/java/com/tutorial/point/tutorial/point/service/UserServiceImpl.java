package com.tutorial.point.tutorial.point.service;

import com.tutorial.point.tutorial.point.domain.User;
import com.tutorial.point.tutorial.point.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        //ThrowNoUserFoundException
        return user.orElse(null);
    }

    @Override
    public User fetchUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public List<User> fetchUsersByCourse(String course) {
        List<User> userList =  userRepo.findByCourseEnrolledTo(course);
        if(userList.size()>0){
            return userList;
        }else {
            return new ArrayList<>(); //throw NoUserFound exception
        }
    }

    @Override
    public String saveUser(User user) {
            userRepo.save(user);
            return "userid";
    }
}
