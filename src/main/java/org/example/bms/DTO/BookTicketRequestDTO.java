package org.example.bms.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class BookTicketRequestDTO {
    private List<Long> seatInShowIDs;
    private Long userId;


}
