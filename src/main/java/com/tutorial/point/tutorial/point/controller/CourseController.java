package com.tutorial.point.tutorial.point.controller;

import com.tutorial.point.tutorial.point.domain.Course;
import com.tutorial.point.tutorial.point.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("course/fetchAllCourse")
    public List<Course> getAllCourseList(){
        return courseService.fetchAllCourseList();
    }

    @GetMapping("course/fetchAllCourse/courseId/{courseID}")
    public Course fetchCourseById(@PathVariable String courseID){
        return courseService.fetchCourseByID(courseID);
    }

    @GetMapping("course/fetchAllCourse/Faculty/{facultyName}")
    public List<Course> fetchCourseByFacultyName(@PathVariable String facultyName){
        return courseService.fetchCourseByFaculty(facultyName);
    }

    @GetMapping("course/fetchAllCourse/courseName/{courseName}")
    public List<Course> fetchCourseByCourseName(@PathVariable String courseName){
        return courseService.fetchCourseByName(courseName);
    }

    @PostMapping("course/saveCourse")
    public String registerCourse(@RequestBody Course course){
       courseService.saveCourse(course);
        return("Course saved successfully");
    }

}
