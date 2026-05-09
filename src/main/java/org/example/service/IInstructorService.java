package org.example.service;

import org.example.entity.Instructor;
import org.example.entity.Section;

import java.util.List;

public interface IInstructorService {
    void addInstructor(Instructor instructor);
    void assignInstructorToSection(String instructorID, Section section);
    Instructor getInstructorDetails(String instructorID);
    List<Instructor> getAllInstructors();
    void updateInstructor(Instructor instructor);
    void removeInstructor(String instructorID);
}