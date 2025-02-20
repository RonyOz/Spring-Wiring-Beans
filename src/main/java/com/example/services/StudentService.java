package com.example.services;

import java.util.List;

import com.example.model.Course;
import com.example.model.Student;
import com.example.repositories.StudentRepository;

public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * @return the studentRepository
     */
    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    /**
     * @param studentRepository the studentRepository to set
     */
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void inizializeData() {

        Course course1 = new Course(59,"Compunet 2","Alejandro Muñoz","MA 14:00 15:59, JU 14:00 15:59");
        Course course2 = new Course(23,"COE 2","Andres Garcia","MI 14:00 15:59");
        Course course3 = new Course(17,"Ingesoft 4","Gabriel Tamura","MA 07:00 08:59, JU 07:00 08:59");
        Course course4 = new Course(12,"Psicología Organizacional","Saryth Valencia","VI 11:00 13:00");

        Student student1 = new Student("A00111111", "Andrea Rodriguez", "Ingenieria de Sistemas", List.of(course1, course2, course3));        
        Student student2 = new Student("A00222222", "Blanca Gutiérrrez", "Ingenieria de Sistemas", List.of(course2,course1));        
        Student student3 = new Student("A00333333", "Carlos Zapata", "Psicología",List.of(course4, course2));           
        
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

        System.out.println("Data initialized");
    
    }
}
