package com.crk.library.model;

public class Student extends LibraryMember {

    private String department;

    public Student(int memberId, String name, String department) {
        super(memberId, name);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void displayDetails() {
        System.out.println("----- Student -----");
        System.out.println("Member ID : " + getMemberId());
        System.out.println("Name      : " + getName());
        System.out.println("Department: " + department);
    }
}