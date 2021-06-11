package com.ephemerayne.psychologicaltests

import android.app.Application
import com.ephemerayne.psychologicaltests.di.AppComponentHolder
import com.jakewharton.threetenabp.AndroidThreeTen

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        AppComponentHolder.init(this)
    }
}