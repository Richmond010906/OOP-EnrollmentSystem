package org.example.service;

import org.example.entity.Student;
import java.util.ArrayList;

public class StudentRegistration implements StudentReg{

    private ArrayList<Student> studentLists = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        if (studentLists.size() >= 30){
            System.out.println("Registration Failed: Section i full!");
            return;
        }
        studentLists.add(student);
    }

    @Override
    public void displayAllStudent() {
        System.out.println("==========================================================");
        System.out.printf("%-10s | %-20s | %-15s\n", "ID", "NAME", "PROGRAM");
        System.out.println("----------------------------------------------------------");
        for (Student s : studentLists) {
            System.out.printf("%-10s | %-20s | %-15s\n",
                    s.getPersonID(), s.getPersonName(), s.getProgram());
        }
        System.out.println("==========================================================");
    }

    @Override
    public void updateStudent(Student student){
        for(int i = 0; i < studentLists.size(); i++){
            if(studentLists.get(i).getPersonID().equals(student.getPersonName())){
                studentLists.set(i, student);
                break;
            }
        }
    }

    @Override
    public void deleteStudentRecord(Student student) {
        for (int i = 0; i < studentLists.size(); i++) {
            if (studentLists.get(i).getPersonID().equals(student.getPersonName())) {
                studentLists.remove(i);
                break;
            }
        }
    }
}