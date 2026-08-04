package com.hibernate.demo.main;

import com.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Pagination {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Employee>query1=session.createQuery("from Employee order by id",Employee.class);
        query1.setFirstResult(0);
        query1.setMaxResults(10);
        List<Employee> employees = query1.list();
        for(Employee e:employees){
            System.out.println(e);
        }
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
