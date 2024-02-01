package com.SpringBootMySQL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.List;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceTest {
    @Mock
    private CityRepository cityRepository;
    @InjectMocks
    private CityService cityService;
    @Test
    public void getAllCities(){
        City city1 = new City("Jamalpur","BGD","Dhaka", 35000);
        City city2 = new City("Magura","BGD","Khulna", 45000);

        when(cityRepository.findAll()).thenReturn(asList(city1,city2));

        List<City> cityList = cityService.getAllCities();

        assertThat(cityList).isNotNull();
        assertThat(cityList.size()).isEqualTo(2);
    }
}
