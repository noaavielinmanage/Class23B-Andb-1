package com.project.expenses

import com.guy.common.App_Parent


class App : App_Parent() {
    override fun onCreate() {
        super.onCreate()
        statsClass = AddExpenseActivity::class.java
    }
}