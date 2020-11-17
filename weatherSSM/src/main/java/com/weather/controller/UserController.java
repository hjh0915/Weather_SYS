package com.weather.controller;

import javax.servlet.http.HttpSession;

import com.weather.deal.JsonClient;
import com.weather.deal.JsonConvert;
import com.weather.deal.Weather;
import com.weather.entities.User;
import com.weather.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login")
    public String Login(HttpSession session, Model model, String uname, String upwd){
        User u = new User();
        u.setUname(uname);
        u.setUpwd(upwd);
        User user = null;
        try {
            user = userService.login(u);
            if(user!=null) {
                User customer = userService.getCode(uname);
                JsonClient jsonClient = new JsonClient();
                JsonConvert jsonConvert = new JsonConvert();

                String cityUrl = jsonClient.getUrl(customer.getCity().getCode());

                String cityVisit = jsonClient.visit(cityUrl);
                Weather w = jsonConvert.deal(cityVisit);

                model.addAttribute("weather", w);
                model.addAttribute("today", w.getData().get(0));
                return "/WEB-INF/jsp/oneCity.jsp"; 
            }else{
                System.out.println(user.getUname() + ":" + user.getUcity() + "登录失败！");
                return "redirect:/userWrong.jsp";
            }
        }catch (Exception e) {
            System.out.println("登录失败！");
            return "redirect:/userWrong.jsp";
        }
    }

    @RequestMapping(value = "reg")
    public String Reg(String uname, String upwd, String ucity){
        User user = new User();
        user.setUname(uname);
        user.setUpwd(upwd);
        user.setUcity(ucity);

        try {
            userService.reg(user);
            return "redirect:/userLogin.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error.jsp";
        }
    }
}