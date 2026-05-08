package org.example.service;

import org.example.entity.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRegistrationService implements DepartmentRegistration{
        private List<Department> departments = new ArrayList<>();

    @Override
    public void saveDepartment(Department department) {
        departments.add(department);
    }

    @Override
    public List<Department> displayAll() {
        return departments;
    }

    @Override
    public void updateDepartment(Department department) {

    }

    @Override
    public void viewDepartmentHierarchy(String departmentID) {

    }
}
