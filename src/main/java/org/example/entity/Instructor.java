package org.example.entity;

public  class Instructor extends Person{
    private String course;

    public Instructor(String personID, String personName, String course){
        super(personID, personName);
        this.course = course;
    }

    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }

    @Override
    public void mainTask() {
    }
}
