package com.example.model;

public class Course {
    
    private int id;

    private String name;

    private String professorName;

    private String schedule;

    /**
     * @param id
     * @param name
     * @param professorName
     * @param schedule
     */
    public Course(int id, String name, String professorName, String schedule) {
        this.id = id;
        this.name = name;
        this.professorName = professorName;
        this.schedule = schedule;
    }

    //Override Equals
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Course) {
            Course course = (Course) obj;
            return course.getId() == this.getId();
        }
        return false;
    }
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the professorName
     */
    public String getProfessorName() {
        return professorName;
    }

    /**
     * @param professorName the professorName to set
     */
    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    /**
     * @return the schedule
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * @param schedule the schedule to set
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

}
