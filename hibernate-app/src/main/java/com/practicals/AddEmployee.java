package com.practicals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Calendar;
import java.util.Date;

public class AddEmployee {
    public static void main(String[] args) {
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory sessionFactory = cfg.buildSessionFactory();
            Session session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();

            Employee employee = new Employee();
            employee.setName("Hardik");
            employee.setDept("Sales");
            employee.setSalary(45000.0);
            employee.setDesignation("Sales Manager");
            employee.setDateOfJoin(new Date(122, Calendar.DECEMBER, 20));

            session.save(employee);
            tx.commit();
            System.out.println("Employee Added Successfully");
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
