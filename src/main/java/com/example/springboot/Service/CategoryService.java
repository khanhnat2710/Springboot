package com.example.springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Repositories.CategoryRepository;
import com.example.springboot.entities.category;

@Service
public class CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;

    public List<category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không có danh mục phù hợp"));
    }

    public category createCategory(category category) {
        return categoryRepository.save(category);
    }

    public category updateCategory(Long id, category category) {
        category existing = getCategoryById(id);
        existing.setName(category.getName());
        return categoryRepository.save(existing);
    }

    public category deleteCategory(Long id) {
        category existing = getCategoryById(id);
        categoryRepository.deleteById(id);
        return existing;
    }
}
