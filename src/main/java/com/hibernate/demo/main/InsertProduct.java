package com.hibernate.demo.main;

import com.hibernate.demo.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertProduct {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        Product product = new Product("Iphone17",125000,"Electronics");
        session.persist(product);
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
