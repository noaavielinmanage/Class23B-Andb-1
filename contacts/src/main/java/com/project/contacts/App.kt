package com.project.contacts

import com.guy.common.App_Parent

class App : App_Parent() {
    override fun onCreate() {
        super.onCreate()
        statsClass = AddContactActivity::class.java
    }
}