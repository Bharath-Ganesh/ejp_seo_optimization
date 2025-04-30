package com.xyz.resourceservice.service;

import com.xyz.resourceservice.entity.Resource;
import com.xyz.resourceservice.repository.ResourceRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepository repo;

    public List<Resource> listAll() {
        return repo.findAll();
    }

    public Resource getBySlug(String slug) {
        return repo.findBySlug(slug);
    }

    public List<Resource> search(String q) {
        return repo.search(q);
    }

    public Resource save(Resource r) {
        return repo.save(r);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}