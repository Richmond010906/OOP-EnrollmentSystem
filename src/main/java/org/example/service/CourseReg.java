package org.example.service;

import org.example.entity.Course;

public interface CourseReg {
    void addCourse(Course course);
    void displayAllCourse();
    void updateCourse(Course course);
    void deleteCourseRecord(Course course);
}
