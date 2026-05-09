package org.example.entity;

public class Course{
    private String courseID;
    private String courseName;
    private String program;
    private int units;
    private String prerequisiteCourseID;

    public Course(String courseID, String courseName, String program, int units) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.program = program;
        this.units = units;
        this.prerequisiteCourseID = null;
    }

    public Course(String courseID, String courseName, String program, int units, String prerequisiteCourseID) {
        this(courseID, courseName, program, units);
        this.prerequisiteCourseID = prerequisiteCourseID;
    }

    public String getCourseID() {
        return courseID;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProgram() {
        return program;
    }
    public void setProgram(String program) {
        this.program = program;
    }

    public int getUnits() {
        return units;
    }
    public void setUnits(int units) {
        this.units = units;
    }
    public String getPrerequisiteCourseID() {
        return prerequisiteCourseID;
    }
    public void setPrerequisiteCourseID(String prerequisiteCourseID) {
        this.prerequisiteCourseID = prerequisiteCourseID;
    }

    public boolean hasPrerequisite() {
        return prerequisiteCourseID != null && !prerequisiteCourseID.isEmpty();
    }
    @Override
    public String toString() {
        String prereq = hasPrerequisite() ? ", prereq='" + prerequisiteCourseID + "'" : "";
        return String.format("Course{id='%s', name='%s', program='%s', units=%d%s}",
                courseID, courseName, program, units, prereq);
    }
}