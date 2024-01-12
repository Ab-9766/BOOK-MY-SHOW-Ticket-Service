package org.example.bms.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import org.example.bms.Models.Enums.Gender;

import java.util.List;

@Getter
@Setter
@Entity
public class Actors extends BaseModel{
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;


    @ManyToMany
    private List<Movie> movies;

}
