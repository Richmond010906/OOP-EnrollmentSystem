package org.example;

import java.util.*;

public class Main{
    public static void main(String[] args){

    Student lulu = new Student();
    lulu.setStudentID("2024372391");
    lulu.setStudentName("Charles Richmond De Ocampo");
    lulu.setProgram("CITE");

    Student fuck = new Student();
    fuck.setStudentID("202563728");
    fuck.setStudentName("Justine Lubrica");
    fuck.setProgram("CITE");

    Course ulol = new Course();
    ulol.setCourseID("000202344");
    ulol.setCourseName("Integrative Programming");
    ulol.setProgram("Information Technology");


        System.out.println("Student ID: " + lulu.getStudentID());
        System.out.println("Student Name: " + lulu.getStudentName());
        System.out.println("Program: " + lulu.getProgram());
        System.out.println(" ");
        System.out.println("Student ID: " + fuck.getStudentID());
        System.out.println("Student Name: " + fuck.getStudentName());
        System.out.println("Program: " + fuck.getProgram());
        System.out.println(" ");
        System.out.println("Course ID: " + ulol.getCourseID());
        System.out.println("Course Name: " + ulol.getCourseName());
        System.out.println("Program: " + ulol.getProgram());
    }


}