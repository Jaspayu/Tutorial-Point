package com.tutorial.point.tutorial.point.service;

import com.tutorial.point.tutorial.point.domain.Course;
import com.tutorial.point.tutorial.point.exception.CourseNotFoundException;
import com.tutorial.point.tutorial.point.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseRepo courseRepo;

    @Override
    public List<Course> fetchAllCourseList() {
        return courseRepo.findAll();
    }

    @Override
    public Course fetchCourseByID(String id) {
        Optional<Course> course = courseRepo.findById(id);
        if(course.isEmpty())
            throw new CourseNotFoundException("No course found with this ID");
        return course.get();
    }

    @Override
    public List<Course> fetchCourseByFaculty(String facultyName) {
        List<Course> courseList = courseRepo.findAllByFacultyName(facultyName);
        if(courseList.size() == 0 )
            throw new CourseNotFoundException("No course has been started by this faculty");
        return courseList;
    }

    @Override
    public String saveCourse(Course course) {
        courseRepo.save(course);
        return "Course saved";
    }

    @Override
    public List<Course> fetchCourseByName(String courseName) {
        List<Course> courses =  courseRepo.findAllByCourseName(courseName);
        if(courses.size()==0)
            throw new CourseNotFoundException("No course found with this name");
        return courses;
    }
}
