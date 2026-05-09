package org.example.service;

import org.example.entity.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentRegistration implements IStudentService{

    private final List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        if (student == null) throw new IllegalArgumentException("Student cannot be null.");
        if (student.getPersonID() == null || student.getPersonID().isBlank())
            throw new IllegalArgumentException("Student ID cannot be empty.");
        if (findStudentByID(student.getPersonID()) != null)
            throw new IllegalArgumentException("Duplicate Student ID: '" + student.getPersonID() + "' already exists.");
        students.add(student);
        System.out.println("Student '" + student.getPersonName() + "' registered successfully.");
    }

    @Override
    public void updateStudent(Student student){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getPersonID().equals(student.getPersonID())) {
                students.set(i, student);
                System.out.println("Student '" + student.getPersonName() + "' updated successfully.");
                return;
            }
        }
        throw new IllegalArgumentException("Student ID '" + student.getPersonID() + "' not found.");
    }

    @Override
    public void removeStudent(String studentID) {
        Student s = findStudentByID(studentID);
        if (s == null) throw new IllegalArgumentException("Student ID '" + studentID + "' not found.");
        students.remove(s);
        System.out.println("Student '" + s.getPersonName() + "' removed successfully.");
    }
    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public Student findStudentByID(String studentID) {
        for (Student s : students) {
            if (s.getPersonID().equals(studentID)) return s;
        }
        return null;
    }
}

