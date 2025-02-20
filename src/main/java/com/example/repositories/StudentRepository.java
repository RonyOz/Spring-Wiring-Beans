package com.example.repositories;

import com.example.model.Student;
import java.util.ArrayList;
import java.util.List;


public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public List<Student> findAll() {
        return students;
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