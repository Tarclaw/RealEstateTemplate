package com.realestate.web.example.controllers;

import com.realestate.web.example.repository.GarageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GarageController {

    private GarageRepository repository;

    public GarageController(GarageRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/garages")
    public String getGarages(Model model) {
        model.addAttribute("garages", repository.findAll());
        return "garages";
    }
}
