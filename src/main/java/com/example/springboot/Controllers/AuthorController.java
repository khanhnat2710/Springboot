package com.example.springboot.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.Service.AuthorService;
import com.example.springboot.entities.author;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    public AuthorService authorService;

    @GetMapping
    public List<author> getAllAuthor() {
        return authorService.getAllAuthor();
    }

    @GetMapping("/{id}")
    public author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping("/create")
    public String createAuthor(@RequestBody author author) {
        authorService.createAuthor(author);
        return "Thêm tác giả thành công";
    }

    @PutMapping("/{id}")
    public String updateAuthor(@PathVariable Long id, @RequestBody author author) {
        authorService.updateAuthor(id, author);
        return "Sửa thành công";
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return "Xóa thành công";
    }
}
