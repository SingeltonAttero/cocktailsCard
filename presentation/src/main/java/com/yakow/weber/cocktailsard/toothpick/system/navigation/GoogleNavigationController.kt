package com.yakow.weber.cocktailsard.toothpick.system.navigation

import androidx.navigation.NavController

/**
 * Created on 14.06.19
 * @author YWeber */

class GoogleNavigationController(private val navController: NavController) :
    NavigationControllerProvider {
    override fun nextScreen(screenId: Int) {
        if (navController.currentDestination?.getAction(screenId) != null || navController.graph.any { navDestination -> navDestination.id == screenId }) {
            navController.navigate(screenId)
        } else {
            navController.popBackStack()
        }
    }

    override fun back() {
        navController.popBackStack()
    }

    override fun backTo(screenId: Int?) {
        if (screenId != null) {
            navController.popBackStack(screenId, true)
        } else {
            while (navController.popBackStack()) {
            }
        }
    }

    override fun replace(screenId: Int) {
        navController.popBackStack()
        nextScreen(screenId)
    }
}