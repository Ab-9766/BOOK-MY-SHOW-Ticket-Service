package org.example.bms.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDTO {
    private ResponseStatus status;
    private String message;

    private Long idOfTheDummyTicket;

}
