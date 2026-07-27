package com.hibernate.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(cascade=CascadeType.ALL)
            @JoinTable(
                    name = "student_course",
                    joinColumns = @JoinColumn(name="student_id"),
                    inverseJoinColumns = @JoinColumn(name = "course_id")

            )
    List<Course> courses=new ArrayList<Course>();

    public Student() {}
    public Student( String name) {
        this.name = name;
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

    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
      return  "{ id= "+id+" name= "+name+ "}";
    }
    public void addCourse(Course course) {
        courses.add(course);
        course.getStudents().add(this);
    }
}
