package com.work.Weather.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.work.Weather.entities.User;
import com.work.Weather.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // @Autowired
    // private AdminMapper adminMapper;

    @RequestMapping("login")
    public String Login(HttpSession session, String uname, String upwd) {

        // 获取请求
        User u = new User();
        u.setUname(uname);
        u.setUpwd(upwd);
        User admin = null;

        try {

            admin = adminService.login(u);
            if (admin.getUname().equals("胡俊华") && admin.getUpwd().equals("123")) {

                System.out.println("登录成功");
                return "redirect:/admin/listUser";

            } else {

                session.setAttribute("user", admin);
                System.out.println("error");
                return "reg";

            }

        } catch (Exception e) {

            session.setAttribute("user", admin);
            return "reg";

        }

    }

    @RequestMapping("listUser")
    public String Manage(@RequestParam(required = false, value = "page", defaultValue = "1") Integer page, Model model,
            HttpSession session) {
        // 获取指定页数据(每页行数8)，使用PageHelper插件
        PageHelper.startPage(page, 7);
        List<User> users = adminService.list();
        // 包装数据，使用PageInfo
        PageInfo<User> pageInfo = new PageInfo<>(users);
        System.out.println(pageInfo);

        model.addAttribute("pageInfo", pageInfo);

        return "users";
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public String deleteUser(String uname) {

        System.out.println(uname);
        try {

            adminService.deleteUser(uname);
            return "success";

        } catch (Exception e) {

            e.printStackTrace();
            return "error";

        }

    }

    @RequestMapping("updateUser")
    @ResponseBody
    public String updateUser(String uname, String upwd, String ucity) {

        try {

            System.out.println(uname);

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