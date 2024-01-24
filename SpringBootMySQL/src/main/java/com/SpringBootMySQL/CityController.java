package com.SpringBootMySQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CityController {
    @Autowired
    CityRepository cityRespository;

    @GetMapping("/city")
    public List<City> index(){
        return cityRespository.findAll();
    }
    @GetMapping("/city/{id}")
    public City show(@PathVariable String id){
        int cityId = Integer.parseInt(id);
        return cityRespository.findOne(cityId);
    }

    @PostMapping("/city/search")
    public List<City> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("name");
        return cityRespository.findByName(searchTerm);
    }

    @PostMapping("/city")
    public City create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        String countrycode = body.get("countrycode");
        String district = body.get("district");
        int population = Integer.parseInt(body.get("population"));
        return cityRespository.save(new City(name,countrycode,district,population));
    }

    @PutMapping("/city/{id}")
    public City update(@PathVariable String id, @RequestBody Map<String, String> body){
        int cityId = Integer.parseInt(id);
        // getting city
        City city = cityRespository.findOne(cityId);
        city.setName(body.get("name"));
        city.setCountryCode(body.get("countrycode"));
        city.setDistrict(body.get("district"));
        city.setPopulation(Integer.parseInt(body.get("population")));
        return cityRespository.save(city);
    }

    @DeleteMapping("city/{id}")
    public boolean delete(@PathVariable String id){
        int cityId = Integer.parseInt(id);
         try{
             cityRespository.delete(cityId);
             return true;
         }
         catch(Exception ex){
             return  false;
         }
    }

}
