package com.example.repositories;

import com.example.model.Student;
import java.util.ArrayList;
import java.util.List;


public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    private CourseRepository courseRepository;

    public List<Student> findAll() {
        return students;
    }

    public void save(Student student) {
        students.add(student);
        student.getCourses().forEach(course -> courseRepository.save(course));
        
        System.out.println("Student saved: " + student);
    }

    public StudentRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * @return the courseRepository
     */
    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    /**
     * @param courseRepository the courseRepository to set
     */
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

}