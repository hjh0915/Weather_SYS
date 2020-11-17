package com.weather.service.Impl;

import java.util.List;

import com.weather.entities.Province;
import com.weather.mappers.WeatherMapper;
import com.weather.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService{
    @Autowired
    private WeatherMapper weatherMapper;

    public List<Province> findAllWithCities() {
        return weatherMapper.listProvAndCities();
    }

    public String getCodeByCname(String cname) {
        return weatherMapper.getCodeByCname(cname);
    }
}