package org.example.service;

import org.example.entity.Instructor;
import org.example.entity.Section;
import org.example.service.IInstructorService;

import java.util.ArrayList;
import java.util.List;

public class InstructorRegistration implements IInstructorService {
    private final List<Instructor> instructors = new ArrayList<>();

    @Override
    public void addInstructor(Instructor instructor) {
        if (instructor == null) throw new IllegalArgumentException("Instructor cannot be null.");
        if (instructor.getPersonID() == null || instructor.getPersonID().isBlank())
            throw new IllegalArgumentException("Instructor ID cannot be empty.");
        if (getInstructorDetails(instructor.getPersonID()) != null)
            throw new IllegalArgumentException("Duplicate Instructor ID: '" + instructor.getPersonID() + "' already exists.");
        instructors.add(instructor);
        System.out.println("Instructor '" + instructor.getPersonName() + "' added successfully.");
    }

    @Override
    public void assignInstructorToSection(String instructorID, Section section) {
        Instructor instructor = getInstructorDetails(instructorID);
        if (instructor == null)
            throw new IllegalArgumentException("Instructor ID '" + instructorID + "' not found.");
        if (section == null)
            throw new IllegalArgumentException("Section cannot be null.");
        section.setAssignedInstructor(instructor);
        System.out.println("Instructor '" + instructor.getPersonName() + "' assigned to section '" + section.getSectionName() + "'.");
    }

    @Override
    public Instructor getInstructorDetails(String instructorID) {
        for (Instructor i : instructors) {
            if (i.getPersonID().equals(instructorID)) return i;
        }
        return null;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return new ArrayList<>(instructors);
    }

    @Override
    public void updateInstructor(Instructor instructor) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getPersonID().equals(instructor.getPersonID())) {
                instructors.set(i, instructor);
                System.out.println("Instructor '" + instructor.getPersonName() + "' updated successfully.");
                return;
            }
        }
        throw new IllegalArgumentException("Instructor ID '" + instructor.getPersonID() + "' not found.");
    }

    @Override
    public void removeInstructor(String instructorID) {
        Instructor instr = getInstructorDetails(instructorID);
        if (instr == null) throw new IllegalArgumentException("Instructor ID '" + instructorID + "' not found.");
        instructors.remove(instr);
        System.out.println("Instructor '" + instr.getPersonName() + "' removed successfully.");
    }
}