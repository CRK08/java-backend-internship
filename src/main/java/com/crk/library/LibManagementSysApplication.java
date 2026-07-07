package com.crk.library;

import com.crk.library.model.Book;
import com.crk.library.model.Faculty;
import com.crk.library.model.LibraryMember;
import com.crk.library.model.Student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibManagementSysApplication {

    public static void main(String[] args) {

        SpringApplication.run(LibManagementSysApplication.class, args);

        Book javaBook = new Book(101, "Java Programming", "James Gosling");

        LibraryMember student = new Student(1, "Kavi", "CSE");
        LibraryMember faculty = new Faculty(2, "Ramesh", "IT");

        System.out.println("\n========== BOOK DETAILS ==========");
        javaBook.displayBook();

        System.out.println("\n========== BORROW ==========");
        javaBook.borrowBook();

        System.out.println("\n========== MEMBERS ==========");
        student.displayDetails();
        System.out.println();
        faculty.displayDetails();

        System.out.println("\n========== RETURN ==========");
        javaBook.returnBook();
    }
}