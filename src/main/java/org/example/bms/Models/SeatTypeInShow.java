package org.example.bms.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.bms.Models.Enums.SeatStatus;
import org.example.bms.Models.Enums.SeatType;

@Getter
@Setter
@Entity

public class SeatTypeInShow extends BaseModel{

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    @ManyToOne
    private MovieShow show;

    private int price;

}
