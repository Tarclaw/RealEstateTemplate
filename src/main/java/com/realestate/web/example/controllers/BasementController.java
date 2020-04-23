package com.realestate.web.example.controllers;

import com.realestate.web.example.repository.BasementRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasementController {

    private BasementRepository repository;

    public BasementController(BasementRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/basements")
    public String getBasements(Model model) {
        model.addAttribute("basements", repository.findAll());
        return "basements";
    }
}
