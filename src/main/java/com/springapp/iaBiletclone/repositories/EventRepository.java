package com.springapp.iaBiletclone.repositories;

import com.springapp.iaBiletclone.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
}
