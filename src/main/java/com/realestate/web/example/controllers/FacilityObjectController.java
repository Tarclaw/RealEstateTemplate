package com.realestate.web.example.controllers;

import com.realestate.web.example.repository.FacilityObjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FacilityObjectController {

    private FacilityObjectRepository repository;

    public FacilityObjectController(FacilityObjectRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/facilityObjects")
    public String getFacilityObjects(Model model) {
        model.addAttribute("facilityObjects", repository.findAll());
        return "facilityObjects";
    }
}
