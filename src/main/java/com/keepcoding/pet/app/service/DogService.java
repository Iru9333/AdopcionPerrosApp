package com.keepcoding.pet.app.service;

import com.keepcoding.pet.app.model.Dog;
import com.keepcoding.pet.app.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public List<Dog> getYoungestDogs(int limit) {
        List<Dog> allDogs = dogRepository.findYoungestDogs(Integer.MAX_VALUE);
        return allDogs.size() > limit ? allDogs.subList(0, limit) : allDogs;
    }
    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    public Dog getDogById(Long id) {
        return dogRepository.findById(id).orElse(null);
    }

    public Dog saveDog(Dog dog) {
        return dogRepository.save(dog);
    }

    public void deleteDog(Long id) {
        dogRepository.deleteById(id);
    }
    
    public List<Dog> findByName(String name) {
        return dogRepository.findByNameContainingIgnoreCase(name);
    }
    
}
