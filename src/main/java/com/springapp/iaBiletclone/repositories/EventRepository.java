package com.springapp.iaBiletclone.repositories;

import com.springapp.iaBiletclone.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    List<Event> findByLocationIdOrderByDateAsc(Long locationId);

    List<Event> findAllByCategoryIdOrderByDate(Long categoryId);

    List<Event> findAllOrderByDate();

    @Query("SELECT e FROM Event e WHERE (e.soldTickets * 1.0 / e.totalTickets) > 0.5")
    List<Event> findAllOver50PercentTicketsSold();

    List<Event> findAllBetweenDates(LocalDateTime start, LocalDateTime end);

    @Query("SELECT e FROM Event e WHERE (e.soldTickets * 1.0 / e.totalTickets) > 0.9")
    List<Event> findAllAlmostSoldOut();

    List<Event> findByEventNameContainingOrderByDate(String name);

}
