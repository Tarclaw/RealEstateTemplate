package com.realestate.web.example.controllers;

import com.realestate.web.example.repository.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {

    private ClientRepository repository;

    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/clients")
    public String getClients(Model model) {
        model.addAttribute("clients", repository.findAll());
        return "clients";
    }
}
