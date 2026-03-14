package org.example;

import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Student;
import org.example.service.CourseRegistration;
import org.example.service.StudentRegistration;
import org.example.service.TuitionFeePayment;

public class Main{
    public static void main(String[] args){
        StudentRegistration love = new StudentRegistration();
        CourseRegistration babyko = new CourseRegistration();

        love.addStudent(new Student("S202401", "De Ocampo, Richmond", "Information Technology"));
        love.addStudent(new Student("S202409", "Rosas, Ashley", "Architecture"));

        love.displayAll();

        love.updatePerson(new Student("S202401", "De Ocampo, Richmond", "Computer Science"));
        love.displayAll();

        love.deletePersonRecord(new Student("S202401", "De Ocampo, Richmond", "Information Technology"));
        love.displayAll();


        babyko.addCourse(new Course("101", "BSIT", "CITE"));

        babyko.displayAll();

        babyko.updatePerson(new Course("101", "BSCS", "CITE"));
        babyko.displayAll();

        babyko.deletePersonRecord(new Course("101","BSIT", "CITE"));
        babyko.displayAll();

        TuitionFeePayment tuitionFeePayment = new TuitionFeePayment();
        System.out.println(tuitionFeePayment.calculateTuitionFee(3,0));
        tuitionFeePayment.makePayment(1000);

        System.out.println(tuitionFeePayment.getBalance());
        System.out.println(tuitionFeePayment.isFullyPaid());
    }
}