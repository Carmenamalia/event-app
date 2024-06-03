package com.springapp.iaBiletclone.repositories;

import com.springapp.iaBiletclone.entities.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketCategoryRepository extends JpaRepository<TicketCategory,Long> {


    List<TicketCategory> findByEventId(Long eventId);

}
