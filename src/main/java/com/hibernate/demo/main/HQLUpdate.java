package com.hibernate.demo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLUpdate {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query=session.createQuery("delete from Employee where id=:id");
        query.setParameter("id",52);
        int result=query.executeUpdate();
        System.out.println("Result :"+result);
        transaction.commit();
        session.close();

        Session session1 = sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();
        Query query1=session1.createQuery("update  Employee set salary=:salary where id=:id");
        query1.setParameter("salary",9000);
        query1.setParameter("id",1);
        int result1=query1.executeUpdate();
        System.out.println("Result :"+result1);
        transaction1.commit();
        session1.close();
    }
}
