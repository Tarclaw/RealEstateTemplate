package com.realestate.web.example.controllers;

import com.realestate.web.example.repository.StorageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StorageController {

    private StorageRepository repository;

    public StorageController(StorageRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/storages")
    public String getStorages(Model model) {
        model.addAttribute("storages", repository.findAll());
        return "storages";
    }
}
