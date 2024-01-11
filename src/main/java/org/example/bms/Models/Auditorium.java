package org.example.bms.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.bms.Models.Enums.Features;

import java.util.List;

@Getter
@Setter
@Entity

public class Auditorium extends BaseModel{
    private String number;
    private int maximumRows;
    private int maximumColumns;

    @ManyToOne
    private Theatre theatre;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    List<Features> supportedFeatures;





}
