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
        System.out.println("Instructor " + getPersonName() + "is grading " + course + " assignments");
    }
    @Override
    public String toString() {
        return String.format("Instructor{id='%s', name='%s', course='%s'}", getPersonID(), getPersonName(), course);
    }
}