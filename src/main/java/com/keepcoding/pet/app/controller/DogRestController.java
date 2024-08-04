package com.keepcoding.pet.app.controller;

import com.keepcoding.pet.app.model.Dog;
import com.keepcoding.pet.app.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dogs")
public class DogRestController {

    @Autowired
    private DogService dogService;

    @GetMapping
    public List<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }

    @GetMapping("/{id}")
    public Dog getDogById(@PathVariable Long id) {
        return dogService.getDogById(id);
    }

    @PostMapping
    public Dog saveDog(@RequestBody Dog dog) {
        return dogService.saveDog(dog);
    }

    @DeleteMapping("/{id}")
    public void deleteDog(@PathVariable Long id) {
        dogService.deleteDog(id);
    }

    @GetMapping("/youngest")
    public List<Dog> getYoungestDogs(@RequestParam(defaultValue = "20") int limit) {
        return dogService.getYoungestDogs(limit);
    }

    @GetMapping("/page/{page}")
    public List<Dog> getDogsByPage(@PathVariable int page) {
        int pageSize = 5;
        List<Dog> dogs = dogService.getAllDogs().stream()
                .skip(page * pageSize)
                .limit(pageSize)
                .toList();
        return dogs;
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Dog>> searchDogsByName(@RequestParam String name) {
        List<Dog> dogs = dogService.findByName(name);
        if (dogs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dogs);
    }
}
