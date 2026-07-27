package com.hibernate.demo.main;
import com.hibernate.demo.entity.Departments;
import com.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OneToMany {
    public static void main(String[] args) {
        Configuration configuration=new Configuration().configure();

        SessionFactory sessionFactory=configuration.buildSessionFactory();

        Session session=sessionFactory.openSession();

        Transaction transaction=session.beginTransaction();

        Departments department=new Departments("HR");

        Employee employee=new Employee();
        employee.setName("gopal");
        employee.setSalary(10000);

        Employee emp2 = new Employee();
        emp2.setName("Ram");
        emp2.setSalary(8000);

        department.addEmployee(employee);
        department.addEmployee(emp2);

        session.persist(department);


        transaction.commit();

        session.close();
        Session session1 = sessionFactory.openSession();

        Departments department1 = session1.find(Departments.class, 52);

        System.out.println("Department : " + department1.getDepartmentName());

        System.out.println("Size = " + department1.getEmployees().size());

        for (Employee employee1 : department1.getEmployees()) {
            System.out.println(employee1.getName());
        }

        session1.close();

        sessionFactory.close();




    }
}
