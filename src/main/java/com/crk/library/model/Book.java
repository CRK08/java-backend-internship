package com.crk.library.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import com.crk.library.interfaces.Borrowable;

@Entity
@Table(name = "books")
public class Book implements Borrowable {

    // Encapsulation (Private Fields)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Author cannot be empty")
    private String author;
    public Book() {
    }
    // Constructor
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Getters
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Setters
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Interface Methods
    @Override
    public void borrowBook() {
        System.out.println(title + " has been borrowed.");
    }

    @Override
    public void returnBook() {
        System.out.println(title + " has been returned.");
    }

    // Display Book Details
    public void displayBook() {
        System.out.println("Book ID : " + bookId);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
    }
    @Override
    public String toString() {
        return title;
    }

}