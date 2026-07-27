package com.hibernate.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double salary;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_card_id")
    private IDCard idCard;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Departments department;

    public Employee() {
    }

    public Employee(String name, double salary, IDCard idCard, Departments department) {
        this.name = name;
        this.salary = salary;
        this.idCard = idCard;
        this.department = department;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }
    public Departments getDepartment() {
        return department;
    }
    public void setDepartment(Departments department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}