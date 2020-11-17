package com.weather.utils;

import java.util.ArrayList;
import java.util.List;

import com.weather.entities.City;
import com.weather.entities.Province;

public class ProvUtil {
    public static List<Province> filterCities(List<Province> provinces) {
        List<Province> np = new ArrayList<Province>();
        List<City> nc;
        Province prov = new Province();
        for (Province p : provinces) {
            if (p.getName().equals("重庆")) {
                nc = new ArrayList<City>();
                for (City c : p.getCities()) {
                    //如果省的名称为重庆，并且市的名称中包含了“县”,不加入市列表中
                    if (c.getCname().contains("县")) {
                    } else {
                        nc.add(c);
                    }
                }
                prov.setId(p.getId());
                prov.setName(p.getName());
                prov.setCities(nc);
                np.add(prov);
            } else {
                np.add(p);
            }
        }
        return np;
    }
}