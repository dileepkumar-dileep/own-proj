package com.royal.kitchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.royal.kitchen.service.MenuService;
import com.royal.kitchen.model.MenuItem;

@Controller
public class MenuController {

    @Autowired
    private MenuService service;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", service.getAll());
        return "index";
    }

    @GetMapping("/category/{type}")
    public String category(@PathVariable String type, Model model) {
        model.addAttribute("items", service.getByCategory(type));
        model.addAttribute("type", type);
        return "category";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new MenuItem());
        return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MenuItem item) {
        service.save(item);
        return "redirect:/";
    }
