package com.realestate.web.example.controllers;

import com.realestate.web.example.repository.ApartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApartmentController {

    private ApartmentRepository repository;

    public ApartmentController(ApartmentRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/apartments")
    public String getApartments(Model model) {
        model.addAttribute("apartments", repository.findAll());
        return "apartments";
    }
}
