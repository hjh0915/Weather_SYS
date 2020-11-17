package com.weather.mappers;

import java.util.List;

import com.weather.entities.Province;

public interface WeatherMapper {
    public List<Province> listProvAndCities();
    public String getCodeByCname(String cname);
}