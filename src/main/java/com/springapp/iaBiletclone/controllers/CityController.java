package com.springapp.iaBiletclone.controllers;

import com.springapp.iaBiletclone.entities.City;
import com.springapp.iaBiletclone.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
      /*Adaug un nou oraș în care pot avea loc evenimente (ADMIN)
      Văd toate orașele în care au loc evenimente (ADMIN, OWNER, CLIENT)
      Șterg un oraș (ADMIN)
     */

    CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    //Adaug un nou oraș în care pot avea loc evenimente (ADMIN)
    @PostMapping("/")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        City newCity = cityService.addCity(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCity);
    }

    //Văd toate orașele în care au loc evenimente (ADMIN, OWNER, CLIENT)
    @GetMapping("/")
    public ResponseEntity<List<City>> viewAllCitiesWithEvents() {
        List<City> cities = cityService.findAllCitiesWithEvents();
        return ResponseEntity.ok(cities);
    }

    //Șterg un oraș (ADMIN)
    @DeleteMapping("/{cityId}")
    public ResponseEntity<String> deleteCity(@PathVariable Long cityId) {
        cityService.deleteCityById(cityId);
        return ResponseEntity.ok("City deleted successfully.");
    }
}
