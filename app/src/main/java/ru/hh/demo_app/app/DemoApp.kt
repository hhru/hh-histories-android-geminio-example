package ru.hh.demo_app.app

import android.app.Application
import ru.hh.demo_app.module.AppModule
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.ktp.KTP

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeToothpick()
    }

    private fun initializeToothpick() {
        Toothpick.setConfiguration(Configuration.forDevelopment())
        KTP.openRootScope().installModules(AppModule(this))
    }
}
