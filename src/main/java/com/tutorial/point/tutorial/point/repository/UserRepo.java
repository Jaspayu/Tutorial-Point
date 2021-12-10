package com.tutorial.point.tutorial.point.repository;

import com.tutorial.point.tutorial.point.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    List<User> findByCourseEnrolledTo(String course);
}
