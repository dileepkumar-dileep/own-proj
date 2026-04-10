package com.royal.kitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.royal.kitchen.model.MenuItem;

public interface MenuRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByCategory(String category);
