package com.tutorial.point.tutorial.point.repository;

import com.tutorial.point.tutorial.point.domain.Course;
import com.tutorial.point.tutorial.point.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends MongoRepository<Course,String> {
    List<Course> findAllByFacultyName(String facultyName);
    List<Course> findAllByCourseName(String courseName);
}
