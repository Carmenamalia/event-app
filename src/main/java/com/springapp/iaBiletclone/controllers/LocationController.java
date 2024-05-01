package com.springapp.iaBiletclone.controllers;

import com.springapp.iaBiletclone.dtos.LocationRequestDTO;
import com.springapp.iaBiletclone.entities.City;
import com.springapp.iaBiletclone.entities.Location;
import com.springapp.iaBiletclone.service.CityService;
import com.springapp.iaBiletclone.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/location")
public class LocationController {

    private LocationService locationService;

    private CityService cityService;

    @Autowired
    public LocationController(LocationService locationService,CityService cityService) {
        this.locationService = locationService;
        this.cityService = cityService;
    }

    //Adaug o nouă locație în care pot avea loc evenimente (ADMIN, OWNER)
    @PostMapping("/")
    public ResponseEntity<Location> addLocation(@RequestBody LocationRequestDTO locationRequestDTO) {
        Location newLocation = locationService.addLocation(locationRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLocation);
    }


    // Văd toate locațiile în care pot avea loc evenimente (ADMIN, OWNER, CLIENT)
    @GetMapping("/")
    public ResponseEntity<List<Location>> getAvailableLocations(){
        return ResponseEntity.ok(locationService.findAllLocations());
    }
    //    Văd locațiile din orașul meu (ADMIN, OWNER, CLIENT)
    @GetMapping("/{cityName}")
    public ResponseEntity<Set<Location>> getAllLocationFrom(@PathVariable String cityName){
        City city = cityService.findCityByName(cityName);
        Set<Location> locations = city.getLocations();
        return ResponseEntity.ok(locations);
    }

    //    Șterg o locație (ADMIN, OWNER)
    @DeleteMapping("/{locationId}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long locationId) {
        locationService.deleteLocation(locationId);
        return ResponseEntity.ok("Location deleted successfully.");
    }
}
