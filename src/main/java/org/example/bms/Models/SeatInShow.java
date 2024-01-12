 package org.example.bms.Models;

 import jakarta.persistence.*;
 import lombok.Getter;
 import lombok.Setter;
 import org.example.bms.Models.Enums.SeatStatus;

 import java.util.Date;
 import java.util.List;

 @Getter
 @Setter
 @Entity
public class SeatInShow extends BaseModel{

     @ManyToOne
     private Seat seat;

     @ManyToOne
     private MovieShow show;

     @Enumerated(EnumType.ORDINAL)
     private SeatStatus seatStatus;

     @ManyToOne
     private Ticket ticket;

     private Date lockedAt;

}
