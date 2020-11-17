package com.weather.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weather.entities.User;
import com.weather.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "login")
    public String Login(HttpSession session, String uname, String upwd){
        User u = new User();
        u.setUname(uname);
        u.setUpwd(upwd);
        User admin = null;

        try {
            admin = adminService.login(u);
            if(admin.getUname().equals("胡俊华" )&& admin.getUpwd().equals("123")) {
                return "redirect:/admin/listUser"; 
            }else{
                session.setAttribute("user", admin);
                return "redirect:/adminWrong.jsp";
            }
        }catch (Exception e) {
            session.setAttribute("user", admin);
            return "redirect:/adminWrong.jsp";
        }
    }

    @RequestMapping(value = "listUser")
    public String Manage(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model, HttpSession session){
        //获取指定页数据(每页行数3)，使用PageHelper插件
        PageHelper.startPage(page, 8);
        List<User> users = adminService.list();
        //包装数据，使用PageInfo
        PageInfo pageInfo = new PageInfo(users, 7);
        model.addAttribute("pageInfo", pageInfo);
        return "/WEB-INF/jsp/users.jsp";
    }

    @RequestMapping(value = "deleteUser", method = RequestMethod.POST, produces="text/html; charset=utf-8")
    @ResponseBody
    public String deleteUser(String uname){
        System.out.println(uname);
        try {
            adminService.deleteUser(uname);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.POST, produces="text/html; charset=utf-8")
    @ResponseBody
    public String updateUser(String uname, String upwd, String ucity){
        try {
            User user = new User();
            user.setUname(uname);
            user.setUpwd(upwd);
            user.setUcity(ucity);
            adminService.updateUser(user);
            return "success";

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}