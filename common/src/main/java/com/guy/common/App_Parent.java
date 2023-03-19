package com.guy.common;

import android.app.Application;

import com.guy.common.utils.MSP;
import com.guy.common.utils.MySignalV2;

public abstract class App_Parent extends Application {

    public static String adid = null;
    protected static Class<?> statsClass;

    protected abstract String getWeatherApiKey();
    protected abstract String getAdMobBannerID();

    @Override
    public void onCreate() {
        super.onCreate();

        MySignalV2.initHelper(this);
        MSP.initHelper(this);


        String weatherApiKey = getWeatherApiKey();
        initAPI(weatherApiKey);

        adid = getAdMobBannerID();

    }

    private void initAPI(String api) {
        //
    }
}
