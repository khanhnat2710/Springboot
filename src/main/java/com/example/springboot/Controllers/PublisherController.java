package com.example.springboot.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.Service.PublisherService;
import com.example.springboot.entities.publisher;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
    @Autowired
    public PublisherService publisherService;

    @GetMapping
    public List<publisher> getAllPublisher() {
        return publisherService.getAllPublisher();
    }

    @GetMapping("/{id}")
    public publisher getPublisherById(@PathVariable Long id) {
        return publisherService.getPublisherById(id);
    }

    @PostMapping("/create")
    public String createPublisher(@RequestBody publisher publisher) {
        publisherService.createPublisher(publisher);
        return "Thêm nhà xuất bản thành công";
    }

    @PutMapping("/{id}")
    public String updatePublisher(@PathVariable Long id, @RequestBody publisher publisher) {
        publisherService.updatePublisher(id, publisher);
        return "Sửa thành công";
    }

    @DeleteMapping("/{id}")
    public String deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return "Xóa thành công";
    }
}
