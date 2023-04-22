package com.project.meetings

import com.guy.common.App_Parent


class App : App_Parent() {
    override fun onCreate() {
        super.onCreate()
        statsClass = AddMeetingActivity::class.java
    }
}