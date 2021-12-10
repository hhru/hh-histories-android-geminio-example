package ru.hh.demo_app.module

import android.app.Application
import android.content.Context
import toothpick.config.Module

class AppModule(application: Application) : Module() {

    init {
        bind(Application::class.java).toInstance(application)
        bind(Context::class.java).toInstance(application.applicationContext)
    }
}
