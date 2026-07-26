package com.hibernate.demo.main;

import com.hibernate.demo.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteProduct {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        Product product = s.get( Product.class, 1 );
        if(product!=null){
            s.remove(product);
        }
        System.out.println(product);//deleted
        tx.commit();
        sessionFactory.close();

    }
}
