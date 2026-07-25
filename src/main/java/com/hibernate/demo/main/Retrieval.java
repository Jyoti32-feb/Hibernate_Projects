package com.hibernate.demo.main;

import com.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Retrieval {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
       // Employee employee = session.get(Employee.class, 1);

        //Employee employee = session.get(Employee.class, 100); return null
        //Employee employee = session.byId(Employee.class).load(100);
        Employee employee=session.find(Employee.class, 1);
        System.out.println(employee);
        System.out.println(employee.getName());
        session.close();
        sf.close();
    }
}
