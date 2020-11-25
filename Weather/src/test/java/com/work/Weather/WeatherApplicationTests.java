package com.work.Weather;

import java.util.List;

import com.work.Weather.entities.City;
import com.work.Weather.entities.Province;
import com.work.Weather.mappers.WeatherMapper;
import com.work.Weather.service.WeatherService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeatherApplicationTests {
	@Autowired 
    private WeatherService weatherService;

    @Autowired
    private WeatherMapper weatherMapper;

	@Test
	public void testProvinces() {
		List<Province> provs = weatherService.findAllWithCities();
		for(Province p: provs) {
			System.out.println(p.getName());
		}
		System.out.println(provs.size());
        for (Province p: provs) {
			List<City> cities = p.getCities();
			for(City c: cities) {
				System.out.println(c);
			}
		}
	}

	@Test
    public void testGetCodeByCname() {
        String cname = "南昌";
        String code = weatherMapper.getCodeByCname(cname);
        System.out.println(code);
    }
}
