package com.guy.common;

import android.app.Application;

import com.guy.common.utils.MSP;
import com.guy.common.utils.MySignalV2;

public abstract class App_Parent extends Application {

    protected static Class<?> statsClass;

    protected abstract String getWeatherApiKey();

    @Override
    public void onCreate() {
        super.onCreate();

        MySignalV2.initHelper(this);
        MSP.initHelper(this);


        String weatherApiKey = getWeatherApiKey();
        initAPI(weatherApiKey);

    }

    private void initAPI(String api) {
        //
    }
}
