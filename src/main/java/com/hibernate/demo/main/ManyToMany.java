package com.hibernate.demo.main;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToMany {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        Student student = new Student("dhammu");

        Course course1 = new Course("Java");

        Course course2 = new Course("JavaScript");
        student.addCourse(course1);
        student.addCourse(course2);

        session.persist(student);

        tx.commit();

        session.close();

        Session session1 = sf.openSession();
        Student student1 = session1.find(Student.class, 1);

        System.out.println(student1.getName());

        for (Course c : student1.getCourses()) {
            System.out.println(c.getCname());
        }
        session1.close();
        sf.close();


    }
}
