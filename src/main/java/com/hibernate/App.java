package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Employee.class);
        config.addAnnotatedClass(Department.class);

        // try(SessionFactory factory =config.buildSessionFactory();
        // Session session=factory.openSession()){
        // Transaction tx=session.beginTransaction();
        // try{
        // Employee emp=new Employee("Vishal",80000);
        // session.persist(emp);
        // tx.commit();
        // System.out.println("Employee saved successfully!");
        // System.out.println("Generated ID: " + emp.getId());
        // }catch(RuntimeException e){
        // if(tx.isActive()){
        // tx.rollback();
        // }
        // throw e;
        // }
        // }

        // try(SessionFactory factory =config.buildSessionFactory();
        // Session session=factory.openSession()){

        // Transaction tx = session.beginTransaction();
        // try{
        // Employee emp=session.find(Employee.class,1);
        // if(emp!=null){
        // System.out.println(emp.getName());
        // System.out.println(emp.getSalary());
        // emp.setSalary(10000);
        // System.out.println("New SAlary "+emp.getSalary());

        // }else{
        // System.out.println("Employee Details Not found");
        // }
        // tx.commit();
        // }catch(RuntimeException e){
        // if(tx.isActive()){
        // tx.rollback();
        // }
        // throw e;
        // }
        // }

        // try(SessionFactory factory=config.buildSessionFactory();
        // Session session=factory.openSession()){
        // Transaction tx=session.beginTransaction();
        // try{
        // Employee emp=session.find(Employee.class,1);
        // if(emp!=null){
        // session.remove(emp);
        // System.out.println("Employee marked for deletion");
        // }else{
        // System.out.println("Employee Not Found");

        // }
        // tx.commit();

        // }catch(RuntimeException e){
        // if(tx.isActive()){
        // tx.rollback();
        // }
        // throw e;
        // }
        // }

        // Transcient

        // try (SessionFactory factory = config.buildSessionFactory();
        // Session session = factory.openSession()) {
        // Employee emp = session.find(Employee.class, 2);
        // if (emp != null) {
        // System.out.println(emp.getName());
        // System.out.println(emp.getSalary());
        // System.out.println("Monthly Salary: " + emp.getSalary());
        // System.out.println("Annual Salary: " + emp.getAnnualSalary());

        // } else {
        // System.out.println("Employee Details Not found");
        // }
        // }

        // Embeded and Embedable

        // try (SessionFactory factory = config.buildSessionFactory();
        // Session session = factory.openSession()) {
        // Transaction tx = session.beginTransaction();
        // try {
        // Address address = new Address(
        // "Manipal",
        // "Udupi",
        // "Karnataka",
        // "576104");
        // Employee emp = new Employee("Vishal", 80000,address);
        // session.persist(emp);
        // tx.commit();
        // System.out.println("Employee saved successfully!");
        // System.out.println("Generated ID: " + emp.getId());
        // } catch (RuntimeException e) {
        // if (tx.isActive()) {
        // tx.rollback();
        // }
        // throw e;
        // }
        // }

        // try (SessionFactory factory = config.buildSessionFactory();
        // Session session = factory.openSession()) {
        // Employee emp = session.find(Employee.class, 6);
        // if (emp != null) {
        // System.out.println("Name: " + emp.getName());
        // System.out.println("Salary: " + emp.getSalary());

        // Address address = emp.getAddress();

        // System.out.println("Street: " + address.getStreet());
        // System.out.println("City: " + address.getCity());
        // System.out.println("State: " + address.getState());
        // System.out.println("Pincode: " + address.getPincode());
        // }
        // }

        // Attribute Override
        // try (SessionFactory factory = config.buildSessionFactory();
        // Session session = factory.openSession()) {
        // Transaction tx = session.beginTransaction();
        // try {
        // Address permanentAddress = new Address(
        // "Manchi",
        // "Udupi",
        // "Karnataka",
        // "576102");

        // Address currentAddress = new Address(
        // "BCIT",
        // "Bengaluru",
        // "Karnataka",
        // "560066");
        // Employee emp = new Employee("VishalNayak", 120000,permanentAddress,
        // currentAddress);
        // session.persist(emp);
        // tx.commit();
        // System.out.println("Employee saved successfully!");
        // System.out.println("Generated ID: " + emp.getId());
        // } catch (RuntimeException e) {
        // if (tx.isActive()) {
        // tx.rollback();
        // }
        // throw e;
        // }
        // }

        // RelationShip MApping

        try (SessionFactory factory = config.buildSessionFactory();
                Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                Department dept = session.find(Department.class, 1);
                if (dept != null) {
                    Employee emp = new Employee("Shashank", 74000);

                    dept.addEmployee(emp);

                    session.persist(emp);
                    tx.commit();
                    System.out.println("Employee saved successfully!");
                    System.out.println("Employee ID: " + emp.getId());
                    System.out.println("Department: " + dept.getDepartmentName());
                } else {
                    System.out.println("Department not found!");
                    tx.rollback();
                }
            } catch (RuntimeException e) {
                if (tx.isActive()) {
                    tx.rollback();
                } else {
                    throw e;
                }
            }
        }

        // try (SessionFactory factory = config.buildSessionFactory();
        // Session session = factory.openSession()) {

        // Employee emp = session.find(Employee.class, 8);

        // if (emp != null) {
        // System.out.println("Employee: " + emp.getName());
        // System.out.println("Salary: " + emp.getSalary());

        // Department dept = emp.getDepartment();

        // System.out.println("Department: " + dept.getDepartmentName());
        // }
        // }

        // try (SessionFactory factory = config.buildSessionFactory();
        // Session session = factory.openSession()) {

        // Department dept = session.find(Department.class, 1);

        // if (dept != null) {
        // System.out.println("Department: " + dept.getDepartmentName());

        // for (Employee emp : dept.getEmployees()) {
        // System.out.println(
        // emp.getId() + " | " +
        // emp.getName() + " | " +
        // emp.getSalary());
        // }
        // } else {
        // System.out.println("Department not found");
        // }
        // }
    }
}
