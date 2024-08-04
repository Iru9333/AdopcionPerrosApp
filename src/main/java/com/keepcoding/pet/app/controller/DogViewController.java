package com.keepcoding.pet.app.controller;

import com.keepcoding.pet.app.model.Dog;
import com.keepcoding.pet.app.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dogs")
public class DogViewController {

    @Autowired
    private DogService dogService;

    @GetMapping
    public String getAllDogs(Model model) {
        List<Dog> dogs = dogService.getAllDogs();
        model.addAttribute("dogs", dogs);
        return "dogs";
    }

    @GetMapping("/{id}")
    public String getDogById(@PathVariable Long id, Model model) {
        Dog dog = dogService.getDogById(id);
        model.addAttribute("dog", dog);
        return "dog-detail";
    }

    @GetMapping("/youngest")
    public String getYoungestDogs(Model model) {
        List<Dog> dogs = dogService.getYoungestDogs(20);
        model.addAttribute("dogs", dogs);
        return "dogs";
    }

    @GetMapping("/page/{page}")
    public String getDogsByPage(@PathVariable int page, Model model) {
        int pageSize = 5;
        List<Dog> dogs = dogService.getAllDogs().stream()
                .skip(page * pageSize)
                .limit(pageSize)
                .toList();
        model.addAttribute("dogs", dogs);
        return "dogs";
    }

    @PostMapping
    public String saveDog(@ModelAttribute Dog dog) {
        dogService.saveDog(dog);
        return "redirect:/dogs";
    }

    @DeleteMapping("/{id}")
    public String deleteDog(@PathVariable Long id) {
        dogService.deleteDog(id);
        return "redirect:/dogs";
    }
}
