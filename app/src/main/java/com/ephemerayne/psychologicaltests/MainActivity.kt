package com.ephemerayne.psychologicaltests

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.ephemerayne.presentation.di.ComponentDependenciesProvider
import com.ephemerayne.presentation.di.HasComponentDependencies
import com.ephemerayne.psychologicaltests.di.AppComponentHolder
import com.ephemerayne.psychologicaltests.navigation.NavigationHolder
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasComponentDependencies {
    @Inject
    override lateinit var dependencies: ComponentDependenciesProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       AppComponentHolder.appComponent.inject(this)

        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)
        NavigationHolder.setNavAction(navController)
    }
}