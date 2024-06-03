package com.springapp.iaBiletclone.service;


import com.springapp.iaBiletclone.entities.City;
import com.springapp.iaBiletclone.repositories.CityRepository;
import com.springapp.iaBiletclone.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CityService {

    private CityRepository cityRepository;
    private LocationRepository locationRepository;


    @Autowired
    public CityService(CityRepository cityRepository, LocationRepository locationRepository) {
        this.cityRepository = cityRepository;
        this.locationRepository = locationRepository;

    }

    //Adaug un nou oraș în care pot avea loc evenimente (ADMIN)
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    //Văd toate orașele în care au loc evenimente (ADMIN, OWNER, CLIENT)
    public List<City> getCitiesWithEvents() {
        return locationRepository.findAll().stream()
                .filter(location -> !location.getEvents().isEmpty())
                .map(location -> location.getCity())
                .distinct()
                .collect(Collectors.toList());
    }

    public City findCityByName(String cityName) {
        City city = cityRepository.findByName(cityName).orElseThrow(() -> new RuntimeException("City not found"));
        return city;
    }

    //Șterg un oraș (ADMIN)
    @Transactional
    public void deleteCityById(Long cityId) {
        City city = cityRepository.findById(cityId).orElseThrow(() -> new RuntimeException("city not found"));
        cityRepository.delete(city);

    }
}
