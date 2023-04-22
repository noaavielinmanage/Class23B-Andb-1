package com.project.contacts;

import com.guy.common.App_Parent;

public class App extends App_Parent {
    @Override
    public void onCreate() {
        super.onCreate();
        statsClass = AddContactActivity.class;
    }
}