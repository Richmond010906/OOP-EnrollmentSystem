package org.example.service;

import org.example.entity.Student;

import java.util.List;

public interface IStudentService {
    void addStudent(Student student);
    void updateStudent(Student student);
    void removeStudent(String studentID);
    List<Student> getAllStudents();
    Student findStudentByID(String studentID);
}
