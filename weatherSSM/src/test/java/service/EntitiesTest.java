package service;

import java.util.List;

import com.weather.entities.Province;
// import com.weather.entities.City;
// import com.weather.entities.Province;
import com.weather.entities.User;
import com.weather.mappers.UserMapper;
import com.weather.mappers.WeatherMapper;
// import com.weather.service.AdminService;
import com.weather.service.UserService;
import com.weather.service.WeatherService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EntitiesTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    // @Autowired
    // private AdminService adminService;

    @Autowired 
    private WeatherService weatherService;

    @Autowired
    private WeatherMapper weatherMapper;

    @Test
    public void testUser() {
        User u = new User();
        u.setUname("胡俊华");
        u.setUpwd("123");
        User user = userService.login(u);
        System.out.println(user);
    }

    // @Test 
    // public void testListUser() {
    //     List<User> users = adminService.list();
    //     for(User u: users) {
    //         System.out.println(u);
    //     }
    // }

    @Test
    public void testAll() {
        List<Province> provs = weatherService.findAllWithCities();
        System.out.println(provs.size());
        // for (Province p: provs) {
        //     List<City> cities = p.getCities();
        //     for(City c: cities) {
        //         System.out.println(c);
        //     }
        // }
    }

    @Test
    public void testGetCode1() {
        String uname = "胡俊华";
        User user = userMapper.getCode(uname);
        System.out.println(user.getCity().getCode());
    }

    @Test
    public void testGetCodeByCname() {
        String cname = "南昌";
        String code = weatherMapper.getCodeByCname(cname);
        System.out.println(code);
    }

    @Test 
    public void testGetCodeByCname2() {
        String cname = "南昌";
        String code = weatherService.getCodeByCname(cname);
        System.out.println(code);
    }

    // @Test 
    // public void testUpdate() {
    //     User user = new User();
    //     user.setUname("旺仔");
    //     user.setUpwd("1234");
    //     user.setUcity("贵州");
    //     adminService.updateUser(user);
    //     List<User> users = adminService.list();
    //     for(User u: users) {
    //         System.out.println(u);
    //     }
    // }

    // @Test 
    // public void testDelete() {
    //     String uname = "哇哈哈";
    //     adminService.deleteUser(uname);
    //     List<User> users = adminService.list();
    //     for(User u: users) {
    //         System.out.println(u);
    //     }
    // }

    // @Test
    // public void testAddUser() {
    //     User u = new User();
    //     u.setUname("哇哈哈");
    //     u.setUpwd("1234");
    //     u.setUcity("海淀区");
    //     Integer user = userService.reg(u);
    //     System.out.println(user);
    // }

    
}