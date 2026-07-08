package com.crk.library;

import com.crk.library.model.Book;
import com.crk.library.repository.GenericRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibManagementSysApplication {

    public static void main(String[] args) {

        SpringApplication.run(LibManagementSysApplication.class, args);

        GenericRepository<Book> repository = new GenericRepository<>();

        Book book1 = new Book(101, "Java Programming", "James Gosling");
        Book book2 = new Book(102, "Spring Boot", "Craig Walls");
        Book book3 = new Book(103, "Data Structures", "Mark Allen");

        repository.save(101, book1);
        repository.save(102, book2);
        repository.save(103, book3);

        System.out.println("===== ALL BOOKS =====");

        for (Book book : repository.findAll()) {
            book.displayBook();
            System.out.println();
        }

        System.out.println("===== SEARCH BOOK =====");

        Book found = repository.findById(102);

        if (found != null) {
            found.displayBook();
        }

        System.out.println("\n===== ALL IDS =====");

        for (Integer id : repository.getAllIds()) {
            System.out.println(id);
        }

        repository.delete(103);

        System.out.println("\nBook with ID 103 deleted.");
    }
}