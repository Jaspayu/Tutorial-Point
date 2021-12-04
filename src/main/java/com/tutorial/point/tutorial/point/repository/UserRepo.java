package com.tutorial.point.tutorial.point.repository;

import com.tutorial.point.tutorial.point.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    User findByEmail(String email);
    List<User> findByCourseEnrolledTo(String course);
}
