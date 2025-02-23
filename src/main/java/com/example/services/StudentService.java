package com.example.services;

import java.util.List;

import com.example.model.Course;
import com.example.model.Student;
import com.example.repositories.CourseRepository;
import com.example.repositories.StudentRepository;

public class StudentService {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    /**
     * @return the studentRepository
     */
    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    /**
     * @param studentRepository the studentRepository to set
     */
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void initializeData() {

        Course course1 = new Course(59,"Compunet 2","Alejandro Muñoz","MA 14:00 15:59, JU 14:00 15:59");
        Course course2 = new Course(23,"COE 2","Andres Garcia","MI 14:00 15:59");
        Course course3 = new Course(17,"Ingesoft 4","Gabriel Tamura","MA 07:00 08:59, JU 07:00 08:59");
        Course course4 = new Course(12,"Psicología Organizacional","Saryth Valencia","VI 11:00 13:00");

        Student student1 = new Student("A00111111", "Andrea Rodriguez", "Ingenieria de Sistemas", List.of(course1, course2, course3));        
        Student student2 = new Student("A00222222", "Blanca Gutiérrrez", "Ingenieria de Sistemas", List.of(course2,course1));        
        Student student3 = new Student("A00333333", "Carlos Zapata", "Psicología",List.of(course4, course2));           
        
        addStudent(student1);
        addStudent(student2);
        addStudent(student3);

    }

    public void addStudent(Student student) {
        if (!studentRepository.exists(student)) {
            studentRepository.save(student);
            // Añadir cursos
            student.getCourses().forEach(course -> {
                if (!courseRepository.exists(course)) {
                    courseRepository.save(course);
                }
            });

        } else if (student.getCourses() != null) {
            student.getCourses().forEach(course -> {
                if (!courseRepository.exists(course)) {
                    courseRepository.save(course);
                }
            });

        } else {
            System.out.println("Student does not have courses");
        }

    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

}
