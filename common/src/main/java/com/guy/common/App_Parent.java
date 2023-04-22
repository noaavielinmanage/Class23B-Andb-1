package com.guy.common;
import android.app.Application;

import com.guy.common.utils.MSP;

public abstract class App_Parent extends Application {

    protected static Class<?> statsClass;

    @Override
    public void onCreate() {
        super.onCreate();
        MSP.initHelper(this);
    }

}