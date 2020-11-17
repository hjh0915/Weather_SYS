package com.weather.deal;

import java.util.*;

import lombok.Data;

@Data
public class MyData {
    public String day;
    public String date;
    public String week;
    public String wea;
    public String wea_img;
    public int air;
    public int humidity;
    public String air_leve1;
    public String air_tips;

    public Alarm alarm;

    public String tem1;
    public String tem2;
    public String tem;

    public List<String> win;

    public String win_speed;

    public List<Hour> hours;
    public List<Index> indexes;
}