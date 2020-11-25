package com.work.Weather;

import java.util.List;

import com.work.Weather.entities.City;
import com.work.Weather.entities.Province;
import com.work.Weather.entities.User;
import com.work.Weather.mappers.WeatherMapper;
import com.work.Weather.mappers.UserMapper;
import com.work.Weather.service.UserService;
import com.work.Weather.service.AdminService;
import com.work.Weather.service.WeatherService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeatherApplicationTests {
	@Autowired 
	private WeatherService weatherService;
	
	@Autowired
	private UserService userService;

	@Autowired
    private UserMapper userMapper;

	@Autowired
    private AdminService adminService;

    @Autowired
    private WeatherMapper weatherMapper;

	@Test
	public void testProvinces() {
		List<Province> provs = weatherService.findAllWithCities();
		// for(Province p: provs) {
		// 	System.out.println(p.getName());
		// }
		System.out.println(provs.size());
        // for (Province p: provs) {
		// 	List<City> cities = p.getCities();
		// 	for(City c: cities) {
		// 		System.out.println(c);
		// 	}
		// }
	}

	@Test
    public void testGetCodeByCname() {
        String cname = "南昌";
        String code = weatherMapper.getCodeByCname(cname);
        System.out.println(code);
	}
	
	@Test
    public void testUser() {
        User u = new User();
        u.setUname("胡俊华");
        u.setUpwd("123");
        User user = userService.login(u);
        System.out.println(user);
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
	
	// @Test 
    // public void testListUser() {
    //     List<User> users = adminService.list();
    //     for(User u: users) {
    //         System.out.println(u);
    //     }
	// }
	
	@Test
    public void testGetCode1() {
        String uname = "胡俊华";
        User user = userMapper.getCode(uname);
        System.out.println(user.getCity().getCode());
    }
}
