package com.codeclan.example.employeeservice.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_duration")
    private int projectDuration;

    @JsonIgnoreProperties({"employees"})
    @ManyToMany
    @JoinTable(
            name = "employee_projects",
            joinColumns = {@JoinColumn(name = "project_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "employee_id", nullable = false, updatable = false)}
    )
    private List<Employee> employees;


    public Project(String projectName, int projectDuration) {
        this.projectName = projectName;
        this.projectDuration = projectDuration;
        this.employees = new ArrayList<>();
    }

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    public int getProjectDuration() {
        return projectDuration;
    }

    public void setProjectDuration(int projectDuration) {
        this.projectDuration = projectDuration;
    }
}
