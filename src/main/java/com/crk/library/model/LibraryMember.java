package com.crk.library.model;

public abstract class LibraryMember {

    // Encapsulation
    private int memberId;
    private String name;

    // Constructor
    public LibraryMember(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    // Getters
    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Abstract Method
    public abstract void displayDetails();
}