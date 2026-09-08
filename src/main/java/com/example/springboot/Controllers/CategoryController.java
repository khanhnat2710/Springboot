package com.example.springboot.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.Service.CategoryService;
import com.example.springboot.entities.category;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    @GetMapping
    public List<category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/create")
    public String createCategory(@RequestBody category category) {
        categoryService.createCategory(category);
        return "Thêm danh mục thành công";
    }

    @PutMapping("/{id}")
    public String updateCategory(@PathVariable Long id, @RequestBody category category) {
        categoryService.updateCategory(id, category);
        return "Sửa thành công";
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "Xóa thành công";
    }
}
