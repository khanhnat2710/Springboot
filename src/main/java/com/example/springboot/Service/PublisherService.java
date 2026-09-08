package com.example.springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Repositories.PublisherRepository;
import com.example.springboot.entities.publisher;

@Service
public class PublisherService {
    @Autowired
    public PublisherRepository publisherRepository;

    public List<publisher> getAllPublisher() {
        return publisherRepository.findAll();
    }

    public publisher getPublisherById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không có nhà xuất bản phù hợp"));
    }

    public publisher createPublisher(publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public publisher updatePublisher(Long id, publisher publisher) {
        publisher existing = getPublisherById(id);
        existing.setName(publisher.getName());
        existing.setEmail(publisher.getEmail());
        existing.setPhone(publisher.getPhone());
        return publisherRepository.save(existing);
    }

    public publisher deletePublisher(Long id) {
        publisher existing = getPublisherById(id);
        publisherRepository.deleteById(id);
        return existing;
    }
}
