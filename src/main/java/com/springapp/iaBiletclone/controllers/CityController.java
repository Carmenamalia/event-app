package com.springapp.iaBiletclone.controllers;

import com.springapp.iaBiletclone.dtos.CityRequestDTO;
import com.springapp.iaBiletclone.entities.City;
import com.springapp.iaBiletclone.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    //Adaug un nou oraș în care pot avea loc evenimente (ADMIN)
    @PostMapping("/")
    public ResponseEntity<?> addCity(@RequestBody CityRequestDTO cityRequestDTO) {
        City city = new City();
        city.setName(cityRequestDTO.getName());
        City savedCity = cityService.addCity(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCity);
    }

    //Văd toate orașele în care au loc evenimente (ADMIN, OWNER, CLIENT)
    @GetMapping("/")
    public ResponseEntity<List<City>> getAllCitiesWithEvents() {
        List<City> cities = cityService.getCitiesWithEvents();
        return ResponseEntity.ok(cities);
    }

    //Șterg un oraș (ADMIN)
    @DeleteMapping("/{cityId}")
    public ResponseEntity<String> deleteCity(@PathVariable Long cityId) {
        cityService.deleteCityById(cityId);
        return ResponseEntity.ok("City deleted successfully.");
    }
}
