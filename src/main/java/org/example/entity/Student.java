package org.example.entity;

public class Student extends Person{
    private String program;

    public Student(String personID, String personName, String program){
        super(personID, personName);
        this.program = program;
    }

    public String getProgram(){
        return program;
    }

    public void setProgram(String program){
        this.program = program;
    }

    @Override
    public void mainTask() {
        System.out.println("Student Enrolled");
    }
}
