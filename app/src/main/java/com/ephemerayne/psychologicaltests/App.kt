package com.ephemerayne.psychologicaltests

import android.app.Application
import com.ephemerayne.psychologicaltests.di.AppComponentHolder

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AppComponentHolder.init(this)
    }
}