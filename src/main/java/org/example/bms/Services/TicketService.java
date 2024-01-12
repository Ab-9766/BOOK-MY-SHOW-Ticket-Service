package org.example.bms.Services;


import org.example.bms.Exceptions.SeatNotAvailableException;
import org.example.bms.Exceptions.UserNotFoundException;
import org.example.bms.Models.Enums.SeatStatus;
import org.example.bms.Models.Seat;
import org.example.bms.Models.SeatInShow;
import org.example.bms.Models.Ticket;
import org.example.bms.Models.User;
import org.example.bms.Repositories.SeatInShowRepository;
import org.example.bms.Repositories.TicketRepository;
import org.example.bms.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private TicketRepository ticketRepository;
    private UserRepository userRepository;
    private SeatInShowRepository seatInShowRepository;


    @Autowired
    public TicketService(TicketRepository ticketRepository, UserRepository userRepository,
                         SeatInShowRepository seatInShowRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.seatInShowRepository = seatInShowRepository;
    }
    private boolean IsAvailable(SeatInShow seat){
        if(seat.getSeatStatus().equals(SeatStatus.AVAILABLE)){
            return true;
        }else if(seat.getSeatStatus().equals(SeatStatus.LOCKED)){
            //Logic
            long lockedAt= seat.getLockedAt().getTime();
            long currentTime= System.currentTimeMillis();
            long duration= currentTime - lockedAt;
            long durationInSeconds= duration/1000;
            long durationInMinutes= durationInSeconds/60;
            if(durationInMinutes>=10){
                return true;
            }else{
                return false;
            }
        }
        return false; //In case of blocked always
    }

    public Ticket bookTicket(List<Long> seatInShowIDs, Long userId) throws SeatNotAvailableException, UserNotFoundException {
        //Fetch seatInShow
        //Fetch userId
        //Check if seats are available
        //yes-Lock seats, make dummy ticket and return
        //No- Throw an exception

        List<SeatInShow> seats= SeatInShowRepository.fetchByIDs(seatInShowIDs);
        for(SeatInShow seat: seats){
            if(IsAvailable(seat)==false){
                throw new SeatNotAvailableException();
            }
        }
        Optional<User> userOptional= userRepository.fecthByID(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException();
        }
        User bookedBy= userOptional.get();

        //Locking the seats
        List<SeatInShow> updatedSeats= new ArrayList<>();
        Date current= new Date();
        for(SeatInShow seat: seats){
            seat.setSeatStatus(SeatStatus.LOCKED);
            seat.setLockedAt(current);
            seat= seatInShowRepository.save(seat);
            updatedSeats.add(seat);
        }

        Ticket ticket= new Ticket();
        ticket.setBookedBy(bookedBy);
        ticket.setBookingTime(current);
        ticket.setSelectedSeats(updatedSeats);
        ticket.setAmount(0); //Hit SeatTypeInShow repository to calculate amount

        Ticket savedTicket= ticketRepository.save(ticket);

        return savedTicket;

    }
}
