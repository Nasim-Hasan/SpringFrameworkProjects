package com.SpringBootMySQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    CityRepository cityRespository;

    public List<City> getAllCities(){
        return cityRespository.findAll();
    }

    public City getOneCity(int cityId){
        return cityRespository.findOne(cityId);
    }

    public List<City> searchingCity(String searchTerm){
        return cityRespository.findByName(searchTerm);
    }

    public City creatingCity(City city){
        return cityRespository.save(city);
    }

    public City updatingCity(City city){
        return cityRespository.save(city);
    }

    public City partialUpdatingCity(City city){
        return cityRespository.save(city);
    }

    public void deletingCity(int cityId){
        cityRespository.delete(cityId);
    }

}
