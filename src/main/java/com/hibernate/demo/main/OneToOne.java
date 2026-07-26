package com.hibernate.demo.main;

import com.hibernate.demo.entity.Employee;
import com.hibernate.demo.entity.IDCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOne {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        IDCard card = new IDCard();
        card.setCardNumber("EMP-101");

        Employee emp = new Employee();
        emp.setName("Jyoti");
        emp.setSalary(90000);
        emp.setIdCard(card);

        session.persist(emp);

        tx.commit();

        session.close();
        sessionFactory.close();
    }

}
