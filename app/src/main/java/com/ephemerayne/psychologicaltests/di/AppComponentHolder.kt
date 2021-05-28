package com.ephemerayne.psychologicaltests.di

import android.app.Application

object AppComponentHolder {
    lateinit var appComponent: AppComponent

    fun init(application: Application) {
        appComponent = DaggerAppComponent.builder()
            .context(application)
            .build()
    }
}