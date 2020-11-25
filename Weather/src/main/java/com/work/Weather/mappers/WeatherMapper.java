package com.work.Weather.mappers;

import java.util.List;

import com.work.Weather.entities.Province;

public interface WeatherMapper {
    //获取省市
    public List<Province> listProvAndCities();

    //通过城市名称获取citycode
    public String getCodeByCname(String cname);
}