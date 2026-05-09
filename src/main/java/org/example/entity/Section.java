package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String sectionID;
    private String sectionName;
    private int maxCapacity;
    private Instructor assignedInstructor;
    private List<Student> enrolledStudents;

    public Section(String sectionID, String sectionName, int maxCapacity) {
        this.sectionID = sectionID;
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getSectionID() {
        return sectionID;
    }
    public void setSectionID(String sectionID) {
        this.sectionID = sectionID;
    }

    public String getSectionName() {
        return sectionName;
    }
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    public Instructor getAssignedInstructor() {
        return assignedInstructor;
    }
    public void setAssignedInstructor(Instructor assignedInstructor) {
        this.assignedInstructor = assignedInstructor;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean isFull() {
        return enrolledStudents.size() >= maxCapacity;
    }

    public int getAvailableSlots() {
        return maxCapacity - enrolledStudents.size();
    }

    @Override
    public String toString() {
        return String.format("Section{id='%s', name='%s', capacity=%d, enrolled=%d}",
                sectionID, sectionName, maxCapacity, enrolledStudents.size());
    }
}