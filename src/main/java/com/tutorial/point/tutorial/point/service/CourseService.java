package com.tutorial.point.tutorial.point.service;

import com.tutorial.point.tutorial.point.domain.Course;

import java.util.List;

public interface CourseService {
    List<Course> fetchAllCourseList();
    Course fetchCourseByID(String id);
    List<Course> fetchCourseByFaculty(String facultyName);
    String saveCourse(Course course);
    List<Course> fetchCourseByName(String CourseName);
}
