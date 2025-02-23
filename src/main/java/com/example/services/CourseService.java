package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Course;
import com.example.repositories.CourseRepository;

import jakarta.annotation.PostConstruct;

@Service
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

    @PostConstruct
    public void initializeData() {
    }

    public Course createCourse(int courseId, String name, String teacher, String schedule) {
        return new Course(courseId, name, teacher, schedule);
    }

    public Course getCourse(int courseId) {
        return courseRepository.getCourse(courseId);
    }

    public void addCourse(Course course) {
        if (!courseRepository.exists(course)) {
            courseRepository.save(course);
        }
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
    
}