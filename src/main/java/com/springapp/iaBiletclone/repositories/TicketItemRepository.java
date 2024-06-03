package com.springapp.iaBiletclone.repositories;

import com.springapp.iaBiletclone.entities.TicketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketItemRepository extends JpaRepository<TicketItem,Long> {
}
