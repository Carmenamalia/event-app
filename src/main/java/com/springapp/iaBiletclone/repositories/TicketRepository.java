package com.springapp.iaBiletclone.repositories;

import com.springapp.iaBiletclone.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {


}
