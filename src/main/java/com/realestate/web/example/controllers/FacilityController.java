package com.realestate.web.example.controllers;

import com.realestate.web.example.repository.FacilityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FacilityController {

    private FacilityRepository repository;

    public FacilityController(FacilityRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/facilities")
    public String getFacilities(Model model) {
        model.addAttribute("facilities", repository.findAll());
        return "facilities";
    }
}
