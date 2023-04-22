package com.guy.cola;

import com.guy.common.App_Parent;

public class App extends App_Parent {

    @Override
    protected String getWeatherApiKey() {
        return BuildConfig.WEATHER_API_KEY;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        statsClass = Activity_Stats.class;

    }
}
