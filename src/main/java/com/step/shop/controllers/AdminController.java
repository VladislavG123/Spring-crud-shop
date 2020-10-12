package com.step.shop.controllers;

import com.step.shop.data.ProductsRepository;
import com.step.shop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("admin/")
    public String index(Model model) {
        var products = productsRepository.findAll();

        model.addAttribute("products", products);

        int count = 0;
        for (var p: products) {
            count++;
        }
        model.addAttribute("count", count);

        return "admin/index";
    }


    @GetMapping("admin/form")
    public String form(Model model) {
        return "admin/form";
    }


    @PostMapping("admin/add")
    public String add(Model model, String name, String details, int price) {
        productsRepository.save(new Product(name, details, price));

        return index(model);
    }

    @PostMapping("admin/update")
    public String update(Model model,int id, String name, String details, int price) {
        productsRepository.save(new Product(id, name, details, price));

        return index(model);
    }

    @PostMapping("admin/delete")
    public String delete(Model model, int id) {
        productsRepository.deleteById(id);

        return index(model);
    }
}
