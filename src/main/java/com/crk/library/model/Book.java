package com.crk.library.model;

import com.crk.library.interfaces.Borrowable;

public class Book implements Borrowable {

    // Encapsulation (Private Fields)
    private int bookId;
    private String title;
    private String author;

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
}