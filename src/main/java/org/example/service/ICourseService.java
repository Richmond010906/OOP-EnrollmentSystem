package org.example.service;

import org.example.entity.Course;
import java.util.List;

public interface ICourseService {
    void addCourse(Course course);
    void updateCourse(Course course);
    void removeCourse(String courseID);
    List<Course> getAllCourses();
    Course findCourseByID(String courseID);
}
