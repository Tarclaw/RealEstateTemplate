package com.realestate.web.example.controllers;

import com.realestate.web.example.repository.AddressRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddressController {

    private AddressRepository repository;

    public AddressController(AddressRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/addresses")
    public String getAddresses(Model model) {
        model.addAttribute("addresses", repository.findAll());
        return "addresses";
    }
}
