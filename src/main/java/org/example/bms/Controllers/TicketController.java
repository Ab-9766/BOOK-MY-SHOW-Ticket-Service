package org.example.bms.Controllers;

import org.example.bms.DTO.BookTicketRequestDTO;
import org.example.bms.DTO.BookTicketResponseDTO;
import org.example.bms.DTO.ResponseStatus;
import org.example.bms.Models.Ticket;
import org.example.bms.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


public class TicketController {
    //Generate a Ticket
    //1.Select the seats
//    2. Check if available
//    3.1 Yes-Lock Them---Generate a dummy ticket--redirect to payment gateway---
//    3.2 No-Throw an exception


    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    BookTicketResponseDTO bookTicket(BookTicketRequestDTO bookTicketRequestDTO){
        BookTicketResponseDTO bookTicketResponseDTO= new BookTicketResponseDTO();

        try{
            Ticket ticket= ticketService.bookTicket(bookTicketRequestDTO.getSeatInShowIDs(),bookTicketRequestDTO.getUserId());
            bookTicketResponseDTO.setIdOfTheDummyTicket(ticket.getId());
            bookTicketResponseDTO.setStatus(ResponseStatus.SUCCESS);
            bookTicketResponseDTO.setMessage("Dummy ticket generated successfully. Go to payment gateway to finish booking the ticket");
        }
        catch(Exception ex){
            bookTicketResponseDTO.setStatus(ResponseStatus.FAILURE);
            bookTicketResponseDTO.setMessage("Something wrong happened");
        }
        return bookTicketResponseDTO;
    }
}

//1 select seats(bookTicket)- seats are locked,dummy ticket generated
//2 sent to payment gateway with dummy ticket id, does the payment gets a transaction id and redirected to BMS controller
//3 confirmTicket(ticketId, transactionId)- seats are booked, put payment details in dummy ticket it would become real ticket

