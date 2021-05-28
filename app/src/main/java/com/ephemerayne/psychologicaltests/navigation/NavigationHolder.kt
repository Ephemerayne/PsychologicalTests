package com.ephemerayne.psychologicaltests.navigation

import androidx.navigation.NavController
import java.util.*

object NavigationHolder {
    private var appNavController: NavController? = null

    private val actions: Queue<NavAction> = LinkedList()

    fun setNavAction(navController: NavController?) {
        appNavController = navController
        navController?.let { performActions(it) }
    }

    fun putAction(action: NavController.() -> Unit) {
        appNavController?.let { action(it) } ?: actions.offer(action)
    }

    private fun performActions(navController: NavController) {
        while (actions.isNotEmpty()) {
            actions.poll()?.invoke(navController)
        }
    }
}

private typealias NavAction = NavController.() -> Unit