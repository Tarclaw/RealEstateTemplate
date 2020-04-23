package com.realestate.web.example.controllers;

import com.realestate.web.example.repository.RealEstateAgentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RealEstateAgentController {

    private RealEstateAgentRepository repository;

    public RealEstateAgentController(RealEstateAgentRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/agents")
    public String getRealEstateAgents(Model model) {
        model.addAttribute("agents", repository.findAll());
        return "agents";
    }
}
