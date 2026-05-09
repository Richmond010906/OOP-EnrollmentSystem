package org.example.service;

import org.example.entity.Department;
import org.example.entity.Section;
import org.example.entity.Student;
import java.util.List;

public interface IEnrollmentService {
    void enrollStudentInSection(Student student, Section section);
    void viewDepartmentHierarchy(Department department);
    void addDepartment(Department department);
    void addSectionToDepartment(String departmentID, Section section);
    Department findDepartmentByID(String departmentID);
    List<Department> getAllDepartments();
}