package org.example.service;

import org.example.entity.Department;
import org.example.entity.Instructor;
import org.example.entity.Section;
import org.example.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRegistration implements IEnrollmentService{
    private final List<Department> departments = new ArrayList<>();

    @Override
    public void enrollStudentInSection(Student student, Section section) {
        if (student == null) throw new IllegalArgumentException("Student cannot be null.");
        if (section == null) throw new IllegalArgumentException("Section cannot be null.");

        if (section.isFull()) {
            throw new IllegalStateException(
                    "Enrollment FAILED: Section '" + section.getSectionName() +
                            "' is full! (Capacity: " + section.getMaxCapacity() + " students)");
        }
        for (Student enrolled : section.getEnrolledStudents()) {
            if (enrolled.getPersonID().equals(student.getPersonID())) {
                throw new IllegalArgumentException(
                        "Enrollment FAILED: Student '" + student.getPersonName() + "' is already enrolled in this " +
                                "section.");
            }
        }

        section.getEnrolledStudents().add(student);
        System.out.println("Student '" + student.getPersonName() + "' successfully enrolled in section '"
                + section.getSectionName() + "'. (" + section.getEnrolledStudents().size()
                + "/" + section.getMaxCapacity() + " slots filled)");
    }

    @Override
    public void viewDepartmentHierarchy(Department department) {
        if (department == null) {
            System.out.println("Department not found.");
            return;
        }
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("  DEPARTMENT: [" + department.getDepartmentID() + "] " + department.getDepartmentName());
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        if (department.getSections().isEmpty()) {
            System.out.println("  (No sections registered under this department)");
            return;
        }

        for (Section section : department.getSections()) {
            System.out.println("  SECTION: [" + section.getSectionID() + "] " + section.getSectionName()
                    + "  (" + section.getEnrolledStudents().size() + "/" + section.getMaxCapacity() + " students)");

            // Instructor
            if (section.getAssignedInstructor() != null) {
                Instructor instr = section.getAssignedInstructor();
                System.out.println("Instructor: " + instr.getPersonName()
                        + " (ID: " + instr.getPersonID() + " | Course: " + instr.getCourse() + ")");
            } else {
                System.out.println("Instructor: (Not yet assigned)");
            }

            // Enrolled Students
            if (section.getEnrolledStudents().isEmpty()) {
                System.out.println("No students enrolled yet.");
            } else {
                System.out.println("Enrolled Students:");
                for (Student s : section.getEnrolledStudents()) {
                    System.out.println("  │     • [" + s.getPersonID() + "] " + s.getPersonName()
                            + " (" + s.getProgram() + ")");
                }
            }
            System.out.println("  └─────────────────────────────────────────────────────");
        }
        System.out.println();
    }

    @Override
    public void addDepartment(Department department) {
        if (department == null) throw new IllegalArgumentException("Department cannot be null.");
        if (findDepartmentByID(department.getDepartmentID()) != null)
            throw new IllegalArgumentException("Duplicate Department ID: '" + department.getDepartmentID() + "' already " +
                    "exists.");
        departments.add(department);
        System.out.println("Department '" + department.getDepartmentName() + "' added successfully.");
    }

    @Override
    public void addSectionToDepartment(String departmentID, Section section) {
        Department dept = findDepartmentByID(departmentID);
        if (dept == null)
            throw new IllegalArgumentException("Department ID '" + departmentID + "' not found.");
        dept.addSection(section);
        System.out.println("Section '" + section.getSectionName() + "' added to department '" + dept.getDepartmentName() + "'.");
    }

    @Override
    public Department findDepartmentByID(String departmentID) {
        for (Department d : departments) {
            if (d.getDepartmentID().equals(departmentID)) return d;
        }
        return null;
    }

    @Override
    public List<Department> getAllDepartments() {
        return new ArrayList<>(departments);
    }
    // Helper: find a Section across all departments
    public Section findSectionByID(String sectionID) {
        for (Department dept : departments) {
            for (Section section : dept.getSections()) {
                if (section.getSectionID().equals(sectionID)) return section;
            }
        }
        return null;
    }
}