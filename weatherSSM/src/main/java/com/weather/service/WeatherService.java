package com.weather.service;

import java.util.List;

import com.weather.entities.Province;

public interface WeatherService {
    public List<Province> findAllWithCities();
    public String getCodeByCname(String cname);
}