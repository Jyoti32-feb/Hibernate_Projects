package com.hibernate.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String cname;

    @ManyToMany(mappedBy = "courses")
    List<Student> students=new ArrayList<Student>();

    public Course() {}

    public Course(String cname) {

        this.cname = cname;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "{ id= "+id+ "course name= "+cname+ "}";
    }
}
