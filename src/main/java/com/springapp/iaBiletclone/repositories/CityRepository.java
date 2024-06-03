package com.springapp.iaBiletclone.repositories;

import com.springapp.iaBiletclone.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {


    Optional<City> findByName(String cityName);

}
