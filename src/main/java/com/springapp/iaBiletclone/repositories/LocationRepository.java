package com.springapp.iaBiletclone.repositories;

import com.springapp.iaBiletclone.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {

    List<Location> findAllByCityName(String cityName);
    @Query("SELECT DISTINCT l FROM Location l JOIN FETCH l.events")
    List<Location> findLocationsWithEvents();
}