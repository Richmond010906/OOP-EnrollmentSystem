package org.example;

import org.example.entity.*;
import org.example.entity.TuitionFeePayment;
import org.example.service.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        IStudentService    studentService    = new StudentRegistration();
        IInstructorService instructorService = new InstructorRegistration();
        ICourseService     courseService     = new CourseRegistration();
        ITuitionService    tuitionService    = new TuitionRegistration();
        IEnrollmentService enrollmentService = new EnrollmentRegistration();
        EnrollmentRegistration enrollmentHelper = (EnrollmentRegistration) enrollmentService;

        Scanner ash = new Scanner(System.in);
        boolean check = true;

        while (check){
            try {
                System.out.println("====================================");
                System.out.println("   DE LA SALLE ENROLLMENT SYSTEM   ");
                System.out.println("====================================");
                System.out.println("    [1] Registrar Portal");
                System.out.println("    [2] HR Portal");
                System.out.println("    [3] Exit");
                System.out.print(" Select Portal: ");
                int pChoice = ash.nextInt();
                ash.nextLine();

                if (pChoice == 1){
                    boolean regLoop = true;
                    while (regLoop){
                        System.out.println("========REGISTRAR PORTAL========");
                        System.out.println("    [1] Register Student");
                        System.out.println("    [2] View ALl Student");
                        System.out.println("    [3] Update Student");
                        System.out.println("    [4] Remove Student");
                        System.out.println("    [5] Add Course");
                        System.out.println("    [6] View All Courses");
                        System.out.println("    [7] Update Course");
                        System.out.println("    [8] Remove Course");
                        System.out.println("    [9] Add Department");
                        System.out.println("    [10] Add Section to Department");
                        System.out.println("    [11] View All Departments");
                        System.out.println("    [12] View Department Hierarchy");
                        System.out.println("    [13] Enroll Student in Section");
                        System.out.println("    [14] Tuition Fee Payment");
                        System.out.println("    [15] Back to Main");
                        System.out.print("Select Option: ");
                        int regOption = ash.nextInt();
                        ash.nextLine();

                        switch (regOption){
                            case 1:
                                try{
                                    System.out.print("Student ID : ");
                                    String id = ash.nextLine().trim();
                                    System.out.print("Full Name  : ");
                                    String name = ash.nextLine().trim();
                                    System.out.print("Program    : ");
                                    String prog = ash.nextLine().trim();
                                    studentService.addStudent(new Student(id, name, prog));
                                } catch (IllegalArgumentException e) { System.out.println("[ERROR] " + e.getMessage());
                                }
                                break;

                            case 2:
                                List<Student> students = studentService.getAllStudents();
                                if (students.isEmpty()) {
                                    System.out.println("No students registered.");
                                    break;
                                }
                                System.out.printf("%-10s | %-20s | %-12s%n", "ID", "NAME", "PROGRAM");
                                System.out.println("─".repeat(47));
                                for (Student s : students)
                                    System.out.printf("%-10s | %-20s | %-12s%n",
                                            s.getPersonID(), s.getPersonName(), s.getProgram());
                                System.out.println("Total: " + students.size() + " student(s)");
                                break;
                            case 3:
                                System.out.print("Student ID to update: "); String uID = ash.nextLine().trim();
                                Student toUpdateS = studentService.findStudentByID(uID);
                                if (toUpdateS == null) {
                                    System.out.println("Student ID " + uID + " not found!"); break;
                                }
                                System.out.print("New Name [" + toUpdateS.getPersonName() + "]: ");
                                String uName = ash.nextLine().trim();
                                System.out.print("New Program [" + toUpdateS.getProgram() + "]: ");
                                String uProg = ash.nextLine().trim();
                                try {
                                    studentService.updateStudent(new Student(uID,
                                            uName.isEmpty() ? toUpdateS.getPersonName() : uName,
                                            uProg.isEmpty() ? toUpdateS.getProgram() : uProg));
                                } catch (IllegalArgumentException e) {
                                    System.out.println("[ERROR] " + e.getMessage());
                                }
                                break;
                            case 4:
                                System.out.print("Student ID to remove: "); String rID = ash.nextLine().trim();
                                Student toRemoveS = studentService.findStudentByID(rID);
                                if (toRemoveS == null) {
                                    System.out.println("Student ID " + rID + " not found!");
                                    break;
                                }
                                System.out.print("Confirm? (yes/no): ");
                                if (ash.nextLine().trim().equalsIgnoreCase("yes")) {
                                    try { studentService.removeStudent(rID); }
                                    catch (IllegalArgumentException e) {
                                        System.out.println("[ERROR] " + e.getMessage());
                                    }
                                } else System.out.println("Cancelled.");
                                break;
                            case 5:
                                try {
                                    System.out.print("Course ID   : ");
                                    String cID = ash.nextLine().trim();
                                    System.out.print("Course Name : ");
                                    String cName = ash.nextLine().trim();
                                    System.out.print("Program     : ");
                                    String cProg = ash.nextLine().trim();
                                    System.out.print("Units       : ");
                                    int cUnits = ash.nextInt(); ash.nextLine();
                                    System.out.print("Prerequisite ID (Enter to skip): ");
                                    String prereq = ash.nextLine().trim();

                                    courseService.addCourse(prereq.isEmpty()
                                            ? new Course(cID, cName, cProg, cUnits)
                                            : new Course(cID, cName, cProg, cUnits, prereq));
                                } catch (IllegalArgumentException e) {
                                    System.out.println("[ERROR] " + e.getMessage());
                                }
                                break;

                            case 6:
                                List<Course> courses = courseService.getAllCourses();
                                if (courses.isEmpty()) {
                                    System.out.println("No courses registered.");
                                    break;
                                }
                                System.out.printf("%-10s | %-20s | %-10s | %-5s | %-10s%n", "ID", "NAME", "PROGRAM",
                                        "UNITS", "PREREQ");
                                System.out.println("─".repeat(62));
                                for (Course c : courses)
                                    System.out.printf("%-10s | %-20s | %-10s | %-5d | %-10s%n",
                                            c.getCourseID(), c.getCourseName(), c.getProgram(), c.getUnits(),
                                            c.hasPrerequisite() ? c.getPrerequisiteCourseID() : "None");
                                break;

                            case 7:
                                System.out.print("Course ID to update: ");
                                String upCID = ash.nextLine().trim();
                                Course toUpdateC = courseService.findCourseByID(upCID);
                                if (toUpdateC == null) {
                                    System.out.println("Course ID " + upCID + " not found!");
                                    break;
                                }
                                System.out.print("New Name [" + toUpdateC.getCourseName() + "]: ");
                                String upCName = ash.nextLine().trim();
                                System.out.print("New Program [" + toUpdateC.getProgram() + "]: ");
                                String upCProg = ash.nextLine().trim();
                                System.out.print("New Units (0 to keep): ");
                                int upCUnits = ash.nextInt(); ash.nextLine();
                                try {
                                    courseService.updateCourse(new Course(upCID,
                                            upCName.isEmpty() ? toUpdateC.getCourseName() : upCName,
                                            upCProg.isEmpty() ? toUpdateC.getProgram() : upCProg,
                                            upCUnits <= 0 ? toUpdateC.getUnits() : upCUnits,
                                            toUpdateC.getPrerequisiteCourseID()));
                                } catch (IllegalArgumentException e) {
                                    System.out.println("[ERROR] " + e.getMessage());
                                }
                                break;

                            case 8:
                                System.out.print("Course ID to remove: ");
                                String remCID = ash.nextLine().trim();
                                Course toRemoveC = courseService.findCourseByID(remCID);
                                if (toRemoveC == null) {
                                    System.out.println("Course ID " + remCID + " not found!");
                                    break;
                                }
                                System.out.print("Confirm? (yes/no): ");
                                if (ash.nextLine().trim().equalsIgnoreCase("yes")) {
                                    try { courseService.removeCourse(remCID); }
                                    catch (IllegalArgumentException e) {
                                        System.out.println("[ERROR] " + e.getMessage());
                                    }
                                } else System.out.println("Cancelled.");
                                break;

                            case 9:
                                try {
                                    System.out.print("Department ID   : "); String dID = ash.nextLine().trim();
                                    System.out.print("Department Name : "); String dName = ash.nextLine().trim();
                                    enrollmentService.addDepartment(new Department(dID, dName));
                                } catch (IllegalArgumentException e) {
                                    System.out.println("[ERROR] " + e.getMessage());
                                }
                                break;

                            case 10:
                                try {
                                    System.out.print("Department ID : ");
                                    String deptID = ash.nextLine().trim();
                                    System.out.print("Section ID    : ");
                                    String sID = ash.nextLine().trim();
                                    System.out.print("Section Name  : ");
                                    String sName = ash.nextLine().trim();
                                    System.out.print("Max Capacity  : ");
                                    int cap = ash.nextInt(); ash.nextLine();
                                    enrollmentService.addSectionToDepartment(deptID, new Section(sID, sName, cap));
                                } catch (IllegalArgumentException e) {
                                    System.out.println("[ERROR] " + e.getMessage());
                                }
                                break;

                            case 11:
                                List<Department> depts = enrollmentService.getAllDepartments();
                                if (depts.isEmpty()) {
                                    System.out.println("No departments registered.");
                                    break;
                                }
                                for (Department d : depts)
                                    System.out.println("  [" + d.getDepartmentID() + "] " + d.getDepartmentName()
                                            + " — " + d.getSections().size() + " section(s)");
                                break;

                            case 12:
                                System.out.print("Department ID: ");
                                String hierID = ash.nextLine().trim();
                                Department hierDept = enrollmentService.findDepartmentByID(hierID);
                                if (hierDept == null)
                                    System.out.println("Department ID " + hierID + " not found!");
                                else
                                    enrollmentService.viewDepartmentHierarchy(hierDept);
                                break;

                            case 13:
                                try {
                                    System.out.print("Student ID : ");
                                    String enSID = ash.nextLine().trim();
                                    Student enStudent = studentService.findStudentByID(enSID);
                                    if (enStudent == null) {
                                        System.out.println("Student ID " + enSID + " not found!");
                                        break;
                                    }
                                    System.out.print("Section ID : ");
                                    String enSecID = ash.nextLine().trim();
                                    Section enSection = enrollmentHelper.findSectionByID(enSecID);
                                    if (enSection == null) {
                                        System.out.println("Section ID " + enSecID + " not found!");
                                        break;
                                    }
                                    System.out.print("Course ID for prerequisite check (Enter to skip): ");
                                    String prereqCID = ash.nextLine().trim();
                                    if (!prereqCID.isEmpty()) {
                                        Course prereqCourse = courseService.findCourseByID(prereqCID);
                                        if (prereqCourse != null && prereqCourse.hasPrerequisite()) {
                                            System.out.println("[INFO] Prerequisite required: " +
                                                    prereqCourse.getPrerequisiteCourseID());
                                            System.out.print("Has student completed it? (yes/no): ");
                                            if (!ash.nextLine().trim().equalsIgnoreCase("yes")) {
                                                System.out.println("[ERROR] Enrollment FAILED: " +
                                                        "Prerequisite not completed.");
                                                break;
                                            }
                                        }
                                    }
                                    enrollmentService.enrollStudentInSection(enStudent, enSection);
                                } catch (IllegalArgumentException | IllegalStateException e) {
                                    System.out.println("[ERROR] " + e.getMessage());
                                }
                                break;

                            case 14:
                                try {
                                    System.out.print("Student ID     : ");
                                    String tSID = ash.nextLine().trim();
                                    System.out.print("Number of Units: ");
                                    int tUnits = ash.nextInt(); ash.nextLine();
                                    System.out.println("Discount: [0] None  [1] Scholar 50%  " +
                                            "[2] Academic 25%  [3] Custom");
                                    System.out.print("Select: ");
                                    int dChoice = ash.nextInt(); ash.nextLine();
                                    double discount = 0;

                                    switch (dChoice) {
                                        case 1: discount = 0.50;
                                        break;
                                        case 2: discount = 0.25;
                                        break;
                                        case 3:
                                            System.out.print("Custom rate (e.g. 0.10): ");
                                            try { discount = Double.parseDouble(ash.nextLine().trim()); }
                                            catch (NumberFormatException e) {
                                                System.out.println("[!] Invalid. No discount applied.");
                                            }
                                            break;
                                        default: break;
                                    }
                                    TuitionFeePayment payment = tuitionService.calculateFee(tSID, tUnits, discount);
                                    System.out.print("Enter payment amount: PHP ");
                                    double tAmount;
                                    try { tAmount = Double.parseDouble(ash.nextLine().trim()); }
                                    catch (NumberFormatException e) {
                                        System.out.println("[!] Invalid amount. Cancelled.");
                                        break;
                                    }
                                    tuitionService.makePayment(payment, tAmount);
                                    System.out.printf("%nTotal Fee   : PHP %.2f%n", payment.getTotalFee());
                                    System.out.printf("Amount Paid : PHP %.2f%n", payment.getAmountPaid());
                                    System.out.printf("Balance     : PHP %.2f%n",
                                            Math.max(0, payment.getRemainingBalance()));
                                    System.out.println("Status      : " + (payment.getRemainingBalance() <= 0 ?
                                            "FULLY PAID" : "OUTSTANDING BALANCE"));
                                } catch (IllegalArgumentException e) {
                                    System.out.println("[ERROR] " + e.getMessage());
                                }
                                break;

                            case 15:
                                regLoop = false;
                                break;

                            default:
                                System.out.println("Invalid Option!");
                                break;
                        }
                    }

                } else if (pChoice == 2) {
                    boolean hrLoop = true;
                    while (hrLoop) {
                        System.out.println("\n===HR PORTAL===");
                        System.out.println("[1] Add Instructor\n[2] View All Instructors\n[3] Update Instructor\n" +
                                "[4] Remove Instructor\n[5] Assign Instructor to Section\n[6] Back to Main");
                        System.out.print("Select Option: ");
                        int hrOption = ash.nextInt();
                        ash.nextLine();

                        switch (hrOption) {

                            case 1:
                                try {
                                    System.out.print("Instructor ID  : "); String iID = ash.nextLine().trim();
                                    System.out.print("Full Name      : "); String iName = ash.nextLine().trim();
                                    System.out.print("Course Handled : "); String iCourse = ash.nextLine().trim();
                                    instructorService.addInstructor(new Instructor(iID, iName, iCourse));
                                } catch (IllegalArgumentException e) {
                                    System.out.println("[ERROR] " + e.getMessage());
                                }
                                break;

                            case 2:
                                List<Instructor> instructors = instructorService.getAllInstructors();
                                if (instructors.isEmpty()) { System.out.println("No instructors registered."); break; }
                                System.out.printf("%-10s | %-20s | %-18s%n", "ID", "NAME", "COURSE HANDLED");
                                System.out.println("─".repeat(53));
                                for (Instructor i : instructors)
                                    System.out.printf("%-10s | %-20s | %-18s%n",
                                            i.getPersonID(), i.getPersonName(), i.getCourse());
                                break;

                            case 3:
                                System.out.print("Instructor ID to update: "); String upIID = ash.nextLine().trim();
                                Instructor toUpdateI = instructorService.getInstructorDetails(upIID);
                                if (toUpdateI == null) { System.out.println("Instructor ID " + upIID + " not found!");
                                    break;
                                }
                                System.out.print("New Name [" + toUpdateI.getPersonName() + "]: ");
                                String newIName = ash.nextLine().trim();
                                System.out.print("New Course [" + toUpdateI.getCourse() + "]: ");
                                String newICourse = ash.nextLine().trim();
                                try {
                                    instructorService.updateInstructor(new Instructor(upIID,
                                            newIName.isEmpty() ? toUpdateI.getPersonName() : newIName,
                                            newICourse.isEmpty() ? toUpdateI.getCourse() : newICourse));
                                } catch (IllegalArgumentException e) {
                                    System.out.println("[ERROR] " + e.getMessage());
                                }
                                break;

                            case 4:
                                System.out.print("Instructor ID to remove: "); String delIID = ash.nextLine().trim();
                                Instructor toRemoveI = instructorService.getInstructorDetails(delIID);
                                if (toRemoveI == null) { System.out.println("Instructor ID " + delIID + " not found!");
                                    break;
                                }
                                System.out.print("Confirm? (yes/no): ");
                                if (ash.nextLine().trim().equalsIgnoreCase("yes")) {
                                    try { instructorService.removeInstructor(delIID); }
                                    catch (IllegalArgumentException e) {
                                        System.out.println("[ERROR] " + e.getMessage());
                                    }
                                } else System.out.println("Cancelled.");
                                break;

                            case 5:
                                try {
                                    System.out.print("Instructor ID : "); String aIID = ash.nextLine().trim();
                                    System.out.print("Section ID    : "); String aSectID = ash.nextLine().trim();
                                    Section aSection = enrollmentHelper.findSectionByID(aSectID);
                                    if (aSection == null) { System.out.println("Section ID " + aSectID + " not found!");
                                        break;
                                    }
                                    instructorService.assignInstructorToSection(aIID, aSection);
                                } catch (IllegalArgumentException e) {
                                    System.out.println("[ERROR] " + e.getMessage());
                                }
                                break;

                            case 6:
                                hrLoop = false;
                                break;

                            default:
                                System.out.println("Invalid Option!");
                                break;
                        }
                    }

                } else if (pChoice == 3) {
                    check = false;
                    System.out.println("Exiting Portal.");

                } else {
                    System.out.println("Invalid Option!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid Option! Enter a valid input.");
                ash.nextLine();
            }
        }
    }
}
