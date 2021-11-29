package com.tutorial.point.tutorial.point.repository;

import com.tutorial.point.tutorial.point.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, String> {
}
