package com.example.repositories;

import com.example.model.Course;
import java.util.ArrayList;
import java.util.List;


public class CourseRepository {
    private List<Course> courses = new ArrayList<>();
    

    public List<Course> findAll() {
        return courses;
    }

    public void save(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public boolean exists(Course course) {
        return courses.contains(course);
    }

    public Course getCourse(int courseId) {
        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }

    
}
