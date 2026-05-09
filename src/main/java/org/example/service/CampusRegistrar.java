package org.example.service;

import org.example.entity.Course;
import org.example.entity.Student;

public class CampusRegistrar {
    private StudentReg studentRegistration;
    private CourseReg courseRegistration;

    public CampusRegistrar(StudentReg studentReg, CourseReg courseReg){
        this.studentRegistration = studentReg;
        this.courseRegistration = courseReg;
    }
    public String addCourse(Course course){
        courseRegistration.addCourse(course);
        return "Success";
    }
    public String displayAllCourse(){
        courseRegistration.displayAllCourse();
        return "Success";
    }
    public String updateCourse(Course course){
        courseRegistration.updateCourse(course);
        return "Success";
    }
    public String deleteCourseRecord(Course course){
        courseRegistration.deleteCourseRecord(course);
        return "Success";
    }

    public String addStudent(Student student){
        studentRegistration.addStudent(student);
        return "Success";
    }
    public String displayAllStudent(){
        studentRegistration.displayAllStudent();
        return "Success";
    }
    public String updateStudent(Student student){
        studentRegistration.updateStudent(student);
        return "Success";
    }
    public String deleteStudentRecord(Student student){
       studentRegistration.deleteStudentRecord(student);
        return "Success";
    }
}
