package com.hibernate.demo.main;

import com.hibernate.demo.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RetrieveOperation {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        Product product= session.get(Product.class,1);
        System.out.println(product);
        Product product1=session.find(Product.class,2);
        System.out.println(product1);
        Product product2=session.find(Product.class,3);
        System.out.println(product2);
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
