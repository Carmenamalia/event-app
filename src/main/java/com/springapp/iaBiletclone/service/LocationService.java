package com.springapp.iaBiletclone.service;

import com.springapp.iaBiletclone.dtos.LocationRequestDTO;
import com.springapp.iaBiletclone.entities.City;
import com.springapp.iaBiletclone.entities.Location;
import com.springapp.iaBiletclone.repositories.CityRepository;
import com.springapp.iaBiletclone.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private LocationRepository locationRepository;
    private CityRepository cityRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository,CityRepository cityRepository) {
        this.locationRepository = locationRepository;
        this.cityRepository = cityRepository;
    }

    //    Adaug o nouă locație în care pot avea loc evenimente (ADMIN, OWNER)
    public Location addLocation(LocationRequestDTO locationRequestDTO) {
        Location newLocation = new Location();
        City city = cityRepository.findById(locationRequestDTO.getCityId()).orElseThrow(()->new RuntimeException("City not found "));
        newLocation.setName(locationRequestDTO.getName());
        newLocation.setAddress(locationRequestDTO.getAddress());
        newLocation.setCity(city);
        return locationRepository.save(newLocation);
    }

    // Văd toate locațiile în care pot avea loc evenimente (ADMIN, OWNER, CLIENT)
    public List<Location> findAllLocations() {

        return locationRepository.findAll();
    }

    //    Văd locațiile din orașul meu (ADMIN, OWNER, CLIENT)
        public List<Location> findAllBy(String cityName) {
        return locationRepository.findAllByCityName(cityName);
    }

    //    Șterg o locație (ADMIN, OWNER)
    public void deleteLocation(Long locationId) {
        Location location = locationRepository.findById(locationId).orElseThrow(()->new RuntimeException("Location not found"));
        locationRepository.delete(location);

    }
}
