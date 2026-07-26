package com.hibernate.demo.main;

import com.hibernate.demo.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateProduct {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        Product product= session.get(Product.class,1);
        product.setPname("Mackbook");
        product.setPprice(150000);
        tx.commit();//no need to merge synchronized the changes when you commit it
        session.close();

        System.out.println(product);

        product.setPprice(170000);//detached object -session close

        Session session1=sessionFactory.openSession();
        Transaction tx1=session1.beginTransaction();

        Product managedProduct=session1.merge(product);

        System.out.println(managedProduct);


        tx1.commit();
        session1.close();
        System.out.println(managedProduct==product);//false
        sessionFactory.close();




    }
}
