package com.guy.instagram;

import com.guy.common.App_Parent;

public class App extends App_Parent {

    @Override
    protected String getWeatherApiKey() {
        return BuildConfig.WEATHER_API_KEY;
    }

    @Override
    protected String getAdMobBannerID() {
        return BuildConfig.AD_MOB_BANNER_ID;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        statsClass = Activity_Stats.class;

    }
}
