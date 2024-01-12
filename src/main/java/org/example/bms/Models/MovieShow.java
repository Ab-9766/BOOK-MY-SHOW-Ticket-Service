package org.example.bms.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class MovieShow extends BaseModel{

    private int LockingTimeout;
    private Date startTime;
    private Date endTime;
    private int maxTicketsAllowedPerUser;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Auditorium auditorium;

    @OneToMany(mappedBy = "show")
    private List<SeatInShow> seatInShows;

    @OneToMany(mappedBy = "show")
    private List<SeatTypeInShow> seatTypeInShows;



}
