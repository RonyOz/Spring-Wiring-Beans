package com.example.repositories;

import com.example.model.Student;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public List<Student> findAll() {
        return students;
    }

    public Student findByCode(String code) {
        return students.stream().filter(student -> student.getCode().equals(code)).findFirst().orElse(null);
    }

    public void save(Student student) {
        students.add(student);        
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public boolean exists(Student student) {
        return students.contains(student);
    }

}