package org.example.bms.Repositories;

import org.example.bms.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Override
    Ticket save(Ticket entity);
}
