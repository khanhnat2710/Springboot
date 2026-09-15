package com.example.springboot.Controllers;

import com.example.springboot.Service.BookService;
import com.example.springboot.entities.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    public BookService bookService;

    @GetMapping
    public List<book> getAllBook() {
        return bookService.getAllBook();
    }

    @GetMapping("/{id}")
    public book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/create")
    public book createBook(@RequestBody book book){
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public book updateBook(@RequestBody book book, @PathVariable Long id){
        return bookService.updateBook(book, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return;
    }
}
