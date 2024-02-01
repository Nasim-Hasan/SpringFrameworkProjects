package com.SpringBootMySQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("/city")
    public List<City> index(){
        return cityService.getAllCities();
    }
    @GetMapping("/city/{id}")
    public City show(@PathVariable String id){
        int cityId = Integer.parseInt(id);
        return cityService.getOneCity(cityId);
    }

    @PostMapping("/city/search")
    public List<City> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("name");
        return cityService.searchingCity(searchTerm);
    }

    @PostMapping("/city")
    public City create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        String countrycode = body.get("countrycode");
        String district = body.get("district");
        int population = Integer.parseInt(body.get("population"));
        return cityService.creatingCity(new City(name,countrycode,district,population));
    }

    @PutMapping("/city/{id}")
    public City update(@PathVariable String id, @RequestBody Map<String, String> body){
        int cityId = Integer.parseInt(id);
        // getting city
        City city = cityService.getOneCity(cityId);
        city.setName(body.get("name"));
        city.setCountryCode(body.get("countrycode"));
        city.setDistrict(body.get("district"));
        city.setPopulation(Integer.parseInt(body.get("population")));
        return cityService.updatingCity(city);
    }

    @PatchMapping("/city/{id}")
    public City partialUpdate(@PathVariable String id, @RequestBody Map<String, String> body){
        int cityId = Integer.parseInt(id);
        // getting city
        City city = cityService.getOneCity(cityId);
        Set<String> keys = body.keySet();
        for(String tmpKey:keys){
            if(tmpKey.equalsIgnoreCase("name")){
                String name = body.get("name");
                city.setName(name);
            }
            else if(tmpKey.equalsIgnoreCase("countrycode")){
                String countrycode=body.get("countrycode");
                city.setCountryCode(countrycode);
            }
            else if (tmpKey.equalsIgnoreCase("district")){
                String district=body.get("district");
                city.setDistrict(district);
            }
            else if(tmpKey.equalsIgnoreCase("population")){
                int population = Integer.parseInt(body.get("population"));
                city.setPopulation(population);
            }
        }
        return cityService.partialUpdatingCity(city);
    }

    @DeleteMapping("city/{id}")
    public boolean delete(@PathVariable String id){
        int cityId = Integer.parseInt(id);
         try{
             cityService.deletingCity(cityId);
             return true;
         }
         catch(Exception ex){
             return  false;
         }
    }

}
