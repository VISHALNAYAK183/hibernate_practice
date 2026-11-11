package com.hibernate;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "employee_name", nullable = false, length = 100)
    private String name;
    private double salary;
    @Transient
    private double annualSalary;

    @ManyToOne 
    @JoinColumn(name="department_id")
    private Department department;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "permanent_street")),
            @AttributeOverride(name = "city", column = @Column(name = "permanent_city")),
            @AttributeOverride(name = "state", column = @Column(name = "permanent_state")),
            @AttributeOverride(name = "pincode", column = @Column(name = "permanent_pincode"))
    })
    private Address permanentAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "current_street")),
            @AttributeOverride(name = "city", column = @Column(name = "current_city")),
            @AttributeOverride(name = "state", column = @Column(name = "current_state")),
            @AttributeOverride(name = "pincode", column = @Column(name = "current_pincode"))
    })
    private Address currentAddress;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, double salary, Address permanentAddress, Address currentAddress) {
        this.name = name;
        this.salary = salary;
        this.permanentAddress = permanentAddress;
        this.currentAddress=currentAddress;
    }

    public Employee(String name, double salary, Department department){
        this.name = name;
        this.salary = salary;
        this.department=department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    public double getAnnualSalary() {
        return salary * 12;
    }

    public Department getDepartment(){
        return department;
    }

    public void setDepartment(Department department){
        this.department=department;
    }
}