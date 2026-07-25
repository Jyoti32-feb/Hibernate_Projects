package com.hibernate.demo.main;

import com.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();
        Employee employee = session.get(Employee.class, 1);
        session.close();

        employee.setSalary(90000);

        Session session1 = sf.openSession();

        Transaction tx = session1.beginTransaction();

        //System.out.println("before update"+employee);
        //employee.setSalary(80000);

        Employee merge = session1.merge(employee);

        System.out.println(employee);
        System.out.println(merge);

        System.out.println(employee==merge);

        tx.commit();
       // System.out.println("after update"+employee);
        session1.close();

        sf.close();
    }
}
