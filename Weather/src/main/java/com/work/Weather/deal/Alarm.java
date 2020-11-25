package com.work.Weather.deal;

import lombok.Data;

@Data
public class Alarm {
    public String alarm_type;
    public String alarm_level;
    public String alarm_content;
}