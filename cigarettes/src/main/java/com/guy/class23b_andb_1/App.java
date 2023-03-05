package com.guy.class23b_andb_1;

import android.app.Application;
import android.content.Intent;

import com.guy.common.App_Parent;
import com.guy.common.utils.MSP;
import com.guy.common.utils.MySignalV2;

public class App extends App_Parent {

    @Override
    protected String getWeatherApiKey() {
        return  "API_FOR_CIGARETTES";
    }

    @Override
    public void onCreate() {
        super.onCreate();

        statsClass = Activity_Stats.class;
    }

}
