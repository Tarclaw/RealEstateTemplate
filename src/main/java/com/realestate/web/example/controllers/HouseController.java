package com.realestate.web.example.controllers;

import com.realestate.web.example.repository.HouseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HouseController {

    private HouseRepository repository;

    public HouseController(HouseRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/houses")
    public String getHouses(Model model) {
        model.addAttribute("houses", repository.findAll());
        return "houses";
    }
}
