package com.guy.common;
import android.app.Application;

import androidx.annotation.Keep;

import com.guy.common.utils.MSP;

@Keep
public abstract class App_Parent extends Application {

    protected static Class<?> statsClass;

    @Override
    public void onCreate() {
        super.onCreate();
        MSP.initHelper(this);
    }

}