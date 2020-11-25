package com.work.Weather.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.work.Weather.deal.JsonClient;
import com.work.Weather.deal.JsonConvert;
import com.work.Weather.deal.Weather;
import com.work.Weather.entities.Province;
import com.work.Weather.service.WeatherService;
import com.work.Weather.utils.ProvUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = {"/","/index.html"})
    public String index(){
        return "index";
    }

    @RequestMapping("/all")
    public String AllWeather(HttpSession session, Model model) {
        List<Province> provs = weatherService.findAllWithCities();
        List<Province> provinces = ProvUtil.filterCities(provs);
        model.addAttribute("provinces", provinces);
        return "main";
    }

    @RequestMapping("/city")
    public String CityWeather(HttpServletRequest request, HttpSession session, Model model) throws IOException {
        
        JsonClient jsonClient = new JsonClient();
        JsonConvert jsonConvert = new JsonConvert();

        String citycode = request.getParameter("citycode");
        String cityUrl = jsonClient.getUrl(citycode);

        String cityVisit = jsonClient.visit(cityUrl);
        Weather w = jsonConvert.deal(cityVisit);

        model.addAttribute("weather", w);
        model.addAttribute("today", w.getData().get(0));
        return "city";
    }

    @RequestMapping("/cityByName")
    public String CityWeatherByCname(HttpServletRequest request, HttpSession session, Model model) throws IOException {
        
        JsonClient jsonClient = new JsonClient();
        JsonConvert jsonConvert = new JsonConvert();

        String cityname = request.getParameter("cityname");
        String citycode = weatherService.getCodeByCname(cityname);
        String cityUrl = jsonClient.getUrl(citycode);

        String cityVisit = jsonClient.visit(cityUrl);
        Weather w = jsonConvert.deal(cityVisit);

        model.addAttribute("weather", w);
        model.addAttribute("today", w.getData().get(0));
        return "oneCity";
    }
}