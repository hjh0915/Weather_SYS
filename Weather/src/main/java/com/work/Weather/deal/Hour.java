package com.work.Weather.deal;

import lombok.Data;

@Data
public class Hour {
    public String day;
    public String wea;
    public String tem;
    public String win;
    public String win_speed;

    public String getTime() {
        int d = day.indexOf("日");
        int len = day.length();

        return day.substring(d+1, len);
    }
}