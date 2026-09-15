package com.example.springboot.Service;

import com.example.springboot.Repositories.AuthorRepository;
import com.example.springboot.Repositories.BookRepository;
import com.example.springboot.Repositories.CategoryRepository;
import com.example.springboot.Repositories.PublisherRepository;
import com.example.springboot.entities.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    public BookRepository bookRepository;

    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public AuthorRepository authorRepository;

    @Autowired
    public PublisherRepository publisherRepository;

    public List<book> getAllBook(){
        return bookRepository.findAll();
    }

    public book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Khong tim thay"));
    }

    public book createBook(book book){
        Long categoryId = book.getCategory().getId();
        Long authorId = book.getAuthor().getId();
        Long publisherId = book.getPublisher().getId();
        if(!categoryRepository.existsById(categoryId)){
            throw new RuntimeException("Khong ton tai category");
        }
        if(!authorRepository.existsById(authorId)){
            throw new RuntimeException("Khong ton tai tac gia");
        }
        if(!publisherRepository.existsById(publisherId)){
            throw new RuntimeException("Khong ton tai nha xuat ban");
        }
        return bookRepository.save(book);
    }

    public book updateBook(book book, Long id){
        book existingBook = getBookById(id);
        Long categoryId = book.getCategory().getId();
        Long authorId = book.getAuthor().getId();
        Long publisherId = book.getPublisher().getId();
        if(!categoryRepository.existsById(categoryId)){
            throw new RuntimeException("Khong ton tai category");
        }
        if(!authorRepository.existsById(authorId)){
            throw new RuntimeException("Khong ton tai tac gia");
        }
        if(!publisherRepository.existsById(publisherId)){
            throw new RuntimeException("Khong ton tai nha xuat ban");
        }
        existingBook.setBookName(book.getBookName());
        existingBook.setPublishYear(book.getPublishYear());
        existingBook.setQuantity(book.getQuantity());
        existingBook.setPrice(book.getPrice());
        existingBook.setImage(book.getImage());
        existingBook.setCategory(book.getCategory());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublisher(book.getPublisher());
        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long id){
        book existingBook = getBookById(id);
        bookRepository.delete(existingBook);
        return;
    }
}
