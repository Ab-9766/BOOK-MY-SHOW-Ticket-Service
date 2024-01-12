package org.example.bms.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.bms.Models.Enums.Features;

import java.util.List;

@Getter
@Setter
@Entity

public class Movie extends BaseModel{
    private int duration;
    private String name;

    @OneToMany(mappedBy = "Movie")
    private List<MovieShow> shows;

    @ManyToMany(mappedBy = "Movies")
    private List<Actors> actors;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Features> requiredFeatures;

}
