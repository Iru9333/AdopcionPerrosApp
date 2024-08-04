package com.keepcoding.pet.app.model;

import java.time.LocalDate;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private LocalDate birthDate;
    private String breed;
    private Float weight;
    private Boolean hasChip;
    private String photoUrl;
    
}
