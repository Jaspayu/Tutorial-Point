package com.tutorial.point.tutorial.point.service;

import com.tutorial.point.tutorial.point.domain.User;
import com.tutorial.point.tutorial.point.exception.UserNotFoundException;
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
        }else
        {
            throw new UserNotFoundException("No User Found For ID " + uuid);
        }
    }

    @Override
    public User fetchUserByEmail(String email) {
       Optional<User> user =  userRepo.findByEmail(email);
       if(user.isPresent()){
           return user.get();
       }
       else{
           throw new UserNotFoundException("User not Found for email " + email);
       }
    }

    @Override
    public List<User> fetchUsersByCourse(String course) {
        List<User> userList =  userRepo.findByCourseEnrolledTo(course);
        if(userList.size()>0){
            return userList;
        }else {
            throw new UserNotFoundException("No User has enrolled for this course");
        }
    }

    @Override
    public String saveUser(User user) {
            userRepo.save(user);
            return "userid";
    }
}
