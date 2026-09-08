package com.example.springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Repositories.AuthorRepository;
import com.example.springboot.entities.author;

@Service
public class AuthorService {
    @Autowired
    public AuthorRepository authorRepository;

    public List<author> getAllAuthor() {
        return authorRepository.findAll();
    }

    public author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không có tác giả phù hợp"));
    }

    public author createAuthor(author author) {
        return authorRepository.save(author);
    }

    public author updateAuthor(Long id, author author) {
        author existing = getAuthorById(id);
        existing.setName(author.getName());
        return authorRepository.save(existing);
    }

    public author deleteAuthor(Long id) {
        author existing = getAuthorById(id);
        authorRepository.deleteById(id);
        return existing;
    }
}
