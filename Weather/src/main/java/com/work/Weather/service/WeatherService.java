package com.work.Weather.service;

import com.work.Weather.entities.Province;
import java.util.List;

public interface WeatherService {
    List<Province> findAllWithCities();
    public String getCodeByCname(String cname);
}