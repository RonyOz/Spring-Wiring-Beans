package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.repositories.CourseRepository;
import com.example.repositories.StudentRepository;
import com.example.services.CourseService;
import com.example.services.StudentService;

@Configuration
public class AppConfig {
    
    @Bean
    public StudentRepository studentRepository() {
        return new StudentRepository();
    }

    @Bean
    public CourseRepository courseRepository() {
        return new CourseRepository();
    }

    @Bean(initMethod = "initializeData")
    public StudentService studentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        return new StudentService(studentRepository, courseRepository);
    }

    @Bean(initMethod = "initializeData")
    public CourseService courseService(CourseRepository courseRepository) {
        return new CourseService(courseRepository);
    }
    
}
