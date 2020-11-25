package com.work.Weather.entities;

public class User {

    private String uname;
    private String upwd;
    private String ucity;
    City city;

    @Override
    public String toString() {
        return "User{" + "uname=" + uname + ",upwd=" + upwd + ",ucity=" + ucity + "}";
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUcity() {
        return ucity;
    }

    public void setUcity(String ucity) {
        this.ucity = ucity;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}