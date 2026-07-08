package com.crk.library.controller;

import com.crk.library.model.Book;
import com.crk.library.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    // Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    // Get book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    // Search books by author (Custom JPQL)
    @GetMapping("/author")
    public List<Book> getBooksByAuthor(@RequestParam String author) {
        return repository.findBooksByAuthor(author);
    }

    // Add a new book
    @PostMapping
    public Book addBook(@Valid @RequestBody Book book) {
        return repository.save(book);
    }

    // Update an existing book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id,
                           @Valid @RequestBody Book book) {

        book.setBookId(id);
        return repository.save(book);
    }

    // Delete a book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {

        repository.deleteById(id);
        return "Book Deleted Successfully";
    }
}