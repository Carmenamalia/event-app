package com.springapp.iaBiletclone.service;

import com.springapp.iaBiletclone.entities.City;
import com.springapp.iaBiletclone.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CityService {
    //Adaug un nou oraș în care pot avea loc evenimente (ADMIN)
    //Văd toate orașele în care au loc evenimente (ADMIN, OWNER, CLIENT)
    //Șterg un oraș (ADMIN)
    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }
    public List<City> findAllCitiesWithEvents(){
        return cityRepository.findAll();
    }

/* @Transactional
    public void deleteAllTweetsFromUser1(Long userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("user not found"));
        tweetRepository.deleteAllInBatch(user.getTweets());

 */
    @Transactional
    public void deleteCityById(Long cityId){
        City city = cityRepository.findById(cityId).orElseThrow(()->new RuntimeException("city not found"));
        cityRepository.delete(city);

    }
}
