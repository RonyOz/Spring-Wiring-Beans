package com.example.services;

import java.util.List;

import com.example.model.Course;
import com.example.repositories.CourseRepository;

public class CourseService {

    CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void initializeData() {
    }

    public Course createCourse(int courseId, String name, String teacher, String schedule) {
        return new Course(courseId, name, teacher, schedule);
    }

    public Course getCourse(int courseId) {
        return courseRepository.getCourse(courseId);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
    
}