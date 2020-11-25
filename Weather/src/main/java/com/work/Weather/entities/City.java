package com.work.Weather.entities;

import java.io.Serializable;

public class City implements Serializable {
    private String pid;
    private String code;
    private String cname;
    Province province;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
		this.province = province;
    }

    @Override
    public String toString() {
        return "code:" + code + ", cname:" + cname;
    }
}