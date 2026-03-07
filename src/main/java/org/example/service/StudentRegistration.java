package org.example.service;

import org.example.entity.Student;
import java.util.ArrayList;

public class StudentRegistration {

    private ArrayList<Student> studentLists = new ArrayList<>();

    public void addStudent(Student student) {
        studentLists.add(student);
    }

    public void displayAll() {
        for (Student s : studentLists) {
            System.out.println("Student ID: " + s.getPersonID());
            System.out.println("Student Name: " + s.getPersonName());
            System.out.println("Program: " + s.getProgram());
            System.out.println();
        }
    }

    public void updatePerson(Student student){
        for(int i = 0; i < studentLists.size(); i++){
            if(studentLists.get(i).getPersonID().equals(student.getPersonName())){
                studentLists.set(i, student);
                break;
            }
        }
    }

    public void deletePersonRecord(Student student) {
        for (int i = 0; i < studentLists.size(); i++) {
            if (studentLists.get(i).getPersonID().equals(student.getPersonName())) {
                studentLists.remove(i);
                break;
            }
        }
    }
}