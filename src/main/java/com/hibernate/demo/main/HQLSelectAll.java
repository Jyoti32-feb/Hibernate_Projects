package com.hibernate.demo.main;

import com.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLSelectAll {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Employee> query = session.createQuery("from Employee where salary > :salary And name=:name", Employee.class);
        query.setParameter("salary", 50000);
        query.setParameter("name", "Jyoti");
        List<Employee> employees = query.list();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        transaction.commit();
        session.close();

        Session session1 = sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();

        Query<Employee> query1 = session1.createQuery("from Employee where id =:id", Employee.class);
        query.setParameter("id", 1);

        Employee employee = query1.uniqueResult();

        System.out.println(employee);

        transaction1.commit();
        session1.close();

        Session session2 = sessionFactory.openSession();
        Transaction transaction2 = session2.beginTransaction();

        Query<Employee> query2 = session2.createQuery("from Employee where id =:id", Employee.class);
        query.setParameter("id", 10);

        Employee employee1 = query.getSingleResult();

        System.out.println(employee1);

        transaction2.commit();
        session2.close();
    }

}
