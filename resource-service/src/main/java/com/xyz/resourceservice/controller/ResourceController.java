package com.xyz.resourceservice.controller;

import com.xyz.resourceservice.entity.Resource;
import com.xyz.resourceservice.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    @Autowired
    private ResourceService service;

    @GetMapping
    public List<Resource> list() {
        return service.listAll();
    }

    @GetMapping("/{slug}")
    public Resource get(@PathVariable String slug) {
        return service.getBySlug(slug);
    }

    @GetMapping("/search")
    public List<Resource> search(@RequestParam String q) {
        return service.search(q);
    }

    @PostMapping
    public Resource create(@RequestBody Resource r) {
        return service.save(r);
    }

    @PutMapping("/{id}")
    public Resource update(@PathVariable Long id, @RequestBody Resource r) {
        r.setId(id);
        return service.save(r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
