package com.royal.kitchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.royal.kitchen.model.MenuItem;
import com.royal.kitchen.repository.MenuRepository;

@Service
public class MenuService {

    @Autowired
    private MenuRepository repo;

    public List<MenuItem> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<MenuItem> getAll() {
        return repo.findAll();
    }

    public void save(MenuItem item) {
        repo.save(item);
    }
