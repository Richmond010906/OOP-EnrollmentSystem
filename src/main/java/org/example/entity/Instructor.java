package org.example.entity;

public class Instructor {
    private String instructorID;
    private String instructorName;
    private String course;

    public Instructor(){}

    public Instructor(String instructorID, String instructorName, String course){
        this.instructorID = instructorID;
        this.instructorName = instructorName;
        this.course = course;
    }

    public String getInstructorID(){
        return instructorID;
    }
    public void setInstructorID(String instructorID){
        this.instructorID = instructorID;
    }
    public String getInstructorName(){
        return instructorName;
    }
    public void setInstructorName(String instructorName){
        this.instructorName = instructorName;
    }
    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }

}
