package org.example.service;

import org.example.entity.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRegistration implements ICourseService {

    private final List<Course> courses = new ArrayList<>();

    @Override
    public void addCourse(Course course) {
        if (course == null) throw new IllegalArgumentException("Course cannot be null.");
        if (course.getCourseID() == null || course.getCourseID().isBlank())
            throw new IllegalArgumentException("Course ID cannot be empty.");
        if (findCourseByID(course.getCourseID()) != null)
            throw new IllegalArgumentException("Duplicate Course ID: '" + course.getCourseID() + "' already exists.");
        courses.add(course);
        System.out.println("Course '" + course.getCourseName() + "' added successfully.");
    }

    @Override
    public void updateCourse(Course course){
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseID().equals(course.getCourseID())) {
                courses.set(i, course);
                System.out.println("Course '" + course.getCourseName() + "' updated successfully.");
                return;
            }
        }
        throw new IllegalArgumentException("Course ID '" + course.getCourseID() + "' not found.");
    }

    @Override
    public void removeCourse(String courseID) {
        Course c = findCourseByID(courseID);
        if (c == null) throw new IllegalArgumentException("Course ID '" + courseID + "' not found.");
        courses.remove(c);
        System.out.println("Course '" + c.getCourseName() + "' removed successfully.");
    }
    @Override
    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }

    @Override
    public Course findCourseByID(String courseID) {
        for (Course c : courses) {
            if (c.getCourseID().equals(courseID)) return c;
        }
        return null;
    }
}