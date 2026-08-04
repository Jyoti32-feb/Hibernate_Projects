package com.hibernate.demo.main;

import com.hibernate.demo.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CriteriaClass {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> root = cq.from(Employee.class);

        cq.select(root);

        List<Employee> employees =
                session.createQuery(cq).getResultList();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        session.close();

    }
}
