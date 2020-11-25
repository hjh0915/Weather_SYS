package com.work.Weather.service.Impl;

import java.util.List;

import com.work.Weather.entities.Province;
import com.work.Weather.mappers.WeatherMapper;
import com.work.Weather.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private WeatherMapper weatherMapper;

    public List<Province> findAllWithCities() {
        return weatherMapper.listProvAndCities();
    }

    public String getCodeByCname(String cname) {
        return weatherMapper.getCodeByCname(cname);
    }
}