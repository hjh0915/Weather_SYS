package com.work.Weather.deal;

import com.google.gson.Gson;

public class JsonConvert {

    public Weather deal(String jsonStr) {
        Gson gson = new Gson();
        Weather w = gson.fromJson(jsonStr, Weather.class);
        return w;
    }
}
