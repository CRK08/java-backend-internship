package com.crk.library.controller;

import com.crk.library.model.Book;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {

    private final Map<Integer, Book> books = new HashMap<>();

    public BookController() {
        books.put(101, new Book(101, "Java Programming", "James Gosling"));
        books.put(102, new Book(102, "Spring Boot", "Craig Walls"));
        books.put(103, new Book(103, "Data Structures", "Mark Allen"));
    }

    @GetMapping
    public Collection<Book> getAllBooks() {
        return books.values();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return books.get(id);
    }

    @GetMapping("/search")
    public Collection<Book> searchBook(
            @RequestParam @NotBlank String title) {

        List<Book> result = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }

        return result;
    }

    @PostMapping
    public String addBook(@Valid @RequestBody Book book) {
        books.put(book.getBookId(), book);
        return "Book Added Successfully";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id,
                             @Valid @RequestBody Book book) {

        books.put(id, book);
        return "Book Updated Successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {

        books.remove(id);
        return "Book Deleted Successfully";
    }

}