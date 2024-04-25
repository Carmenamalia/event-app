package com.springapp.iaBiletclone.service;

import com.springapp.iaBiletclone.entities.Location;
import com.springapp.iaBiletclone.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    //    Adaug o nouă locație în care pot avea loc evenimente (ADMIN, OWNER)
    public Location addLocation(Location location) {

        return locationRepository.save(location);
    }

    //    Văd toate locațiile în care pot avea loc evenimente (ADMIN, OWNER, CLIENT)
    public List<Location> findAllLocationsWithEvents() {
        return locationRepository.findLocationsWithEvents();
    }

    //    Văd locațiile din orașul meu (ADMIN, OWNER, CLIENT)
    public List<Location> findAllBy(String cityName) {
        return locationRepository.findAllByCityName(cityName);
    }

    //    Șterg o locație (ADMIN, OWNER)
    public void deleteLocation(String locationName) {

    }
}
