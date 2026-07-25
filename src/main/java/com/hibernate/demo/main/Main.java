package com.hibernate.demo.main;

import com.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx=session.beginTransaction();
        Employee employee = new Employee();
        Employee employee1 = new Employee();
        employee.setName("jyoti");
        employee.setSalary(150000);
        session.persist(employee);
        employee1.setName("Rahul");
        employee1.setSalary(10000);
        session.persist(employee1);
        tx.commit();
        session.close();
        sf.close();


    }
}
