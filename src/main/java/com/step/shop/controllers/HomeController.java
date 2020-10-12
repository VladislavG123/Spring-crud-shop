package com.step.shop.controllers;

import com.step.shop.data.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/")
    public String index(Model model) {
        var products = productsRepository.findAll();

        model.addAttribute("products", products);

        return "index";
    }


}
