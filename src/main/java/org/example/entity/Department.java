package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentID;
    private String departmentName;
    private List<Section> sections;

    public Department(String departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.sections = new ArrayList<>();
    }

    public String getDepartmentID() { return departmentID; }
    public void setDepartmentID(String departmentID) { this.departmentID = departmentID; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public List<Section> getSections() { return sections; }

    public void addSection(Section section) { sections.add(section); }

    @Override
    public String toString() {
        return String.format("Department{id='%s', name='%s', sections=%d}",
                departmentID, departmentName, sections.size());
    }
}