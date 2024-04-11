package com.springapp.iaBiletclone.controllers;

import com.springapp.iaBiletclone.entities.Location;
import com.springapp.iaBiletclone.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    //Adaug o nouă locație în care pot avea loc evenimente (ADMIN, OWNER)
    @PostMapping("/")
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        Location newLocation = locationService.addLocation(location);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLocation);
    }
    //Văd toate locațiile în care pot avea loc evenimente (ADMIN, OWNER, CLIENT)
    @GetMapping("/")
    public ResponseEntity<List<Location>> viewAvailableLocations(){
        return ResponseEntity.ok(locationService.findAllLocationsWithEvents());
    }
}
