package com.keepcoding.pet.app.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.keepcoding.pet.app.model.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {


    List<Dog> findByName(String name);

    List<Dog> findByBirthDateBefore(LocalDate birthDate);
    
    @Query("SELECT d FROM Dog d ORDER BY d.birthDate DESC")
    List<Dog> findYoungestDogs(int limit);
    
    List<Dog> findByNameContainingIgnoreCase(String name);

}

