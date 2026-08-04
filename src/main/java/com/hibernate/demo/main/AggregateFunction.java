package com.hibernate.demo.main;

import com.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class AggregateFunction {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();
        long count = session1.createQuery("select count(e) from Employee e",long.class).getSingleResult();
        System.out.println("count :"+count);

        double sum = session1.createQuery("select sum(salary) from Employee ",double.class).getSingleResult();
        System.out.println("sum :"+sum);

        double avg = session1.createQuery("select avg(salary) from Employee ",double.class).getSingleResult();
        System.out.println("avg :"+avg);

         double min = session1.createQuery("select min(salary) from Employee ",double.class).getSingleResult();
         System.out.println("min :"+min);

         double max=session1.createQuery("select max(salary) from Employee ",double.class).getSingleResult();
         System.out.println("max :"+max);

        Query<Employee>query1=session1.createQuery(" from Employee  order by salary desc",Employee.class);
        List<Employee> employees = query1.list();
        for(Employee e:employees){
            System.out.println(e);
        }


        transaction1.commit();
        session1.close();
    }
}
