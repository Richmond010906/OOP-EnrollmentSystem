package org.example.service;

import org.example.entity.Student;

public interface StudentReg {
    void addStudent(Student student);
    void displayAllStudent();
    void updateStudent(Student student);
    void deleteStudentRecord(Student student);
}
