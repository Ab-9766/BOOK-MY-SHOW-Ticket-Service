package org.example.bms.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.bms.Models.Enums.SeatType;

import java.util.List;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String number;
    private int rowNum;
    private int colNum;

    @ManyToOne
    private Auditorium auditorium;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    @OneToMany(mappedBy = "seat")
    private List<SeatInShow> seatInShows;

}
