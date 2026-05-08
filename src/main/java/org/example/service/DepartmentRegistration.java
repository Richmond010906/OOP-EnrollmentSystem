package org.example.service;

import org.example.entity.Department;

import java.util.List;

public interface DepartmentRegistration {
     void saveDepartment(Department department);
     List<Department> displayAll();

     void updateDepartment(Department department);

     void viewDepartmentHierarchy(String departmentID);
}
