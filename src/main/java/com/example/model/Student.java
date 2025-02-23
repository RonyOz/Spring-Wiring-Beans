package com.example.model;

import java.util.ArrayList;

public class Student {
    
    private String code;

    private String name;

    private String program;
    
    private ArrayList<Course> courses;

    public Student(String code, String name, String program, ArrayList<Course> courses) {
        this.code = code;
        this.name = name;
        this.program = program;
        this.courses = courses;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            return student.getCode().equals(this.getCode());
        } else {
            return false;
        }
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the program
     */
    public String getProgram() {
        return program;
    }

    /**
     * @param program the program to set
     */
    public void setProgram(String program) {
        this.program = program;
    }

    /**
     * @return the courses
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * @param courses the courses to set
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "Student [code=" + code + ", name=" + name + ", program=" + program + ", courses=" + courses + "]";
    }

}
