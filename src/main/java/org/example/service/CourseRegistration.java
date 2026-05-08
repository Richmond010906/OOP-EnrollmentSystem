package org.example.service;

import org.example.entity.Course;
import java.util.ArrayList;

public class CourseRegistration implements CourseReg {

    private ArrayList<Course> courseLists = new ArrayList<>();

    @Override
    public void addCourse(Course course) {
        courseLists.add(course);
    }

    @Override
    public void displayAllCourse() {
        for (Course c : courseLists) {
            System.out.println("Course ID: " + c.getCourseID());
            System.out.println("Course Name: " + c.getCourseName());
            System.out.println("Program: " + c.getProgram());
            System.out.println();
        }
    }

    @Override
    public void updateCourse(Course course){
        for(int i = 0; i < courseLists.size(); i++){
            if(courseLists.get(i).getCourseID().equals(course.getCourseID())){
                courseLists.set(i, course);
                break;
            }
        }
    }

    @Override
    public void deleteCourseRecord(Course course){
        for(int i = 0; i < courseLists.size(); i++){
            if(courseLists.get(i).getCourseID().equals(course.getCourseID())){
                courseLists.remove(i);
                break;
            }
        }
    }
}