package com.hibernate.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String departmentName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    public Departments() {}

    public Departments( String departmentName ) {

        this.departmentName = departmentName;

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDepartmentName() {

        return departmentName;
    }
    public void setDepartmentName(String departmentName) {

        this.departmentName = departmentName;
    }
    public List<Employee> getEmployees() {

        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {

        return "{ id = " + id + ", departmentName = " + departmentName +   "}";
    }

    public void addEmployee(Employee employee) {

        employees.add(employee);

        employee.setDepartment(this);


    }
}
