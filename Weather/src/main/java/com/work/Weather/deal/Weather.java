package com.work.Weather.deal;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Weather {
    public String cityid;
    public String update_time; 
    public String city;
    public String cityEn;
    public String country;
    public String countryEn;

    public List<MyData> data;

    public List<MyData> getData() {
        return data;
    }
    public void setData(List<MyData> data) {
        this.data = data;
    }

    public List<MyData> getNotToday() {
        return data.stream().filter(x -> (!x.day.contains("今天"))).collect(Collectors.toList());
    }
}