package com.yakow.weber.cocktailsard.toothpick.system.navigation

import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.*

/**
 * Created on 14.06.19
 * @author YWeber */

class GraphNavigator(private val navigationController: NavigationControllerProvider) : Navigator {
    override fun applyCommands(commands: Array<out Command>?) {
        commands?.forEach { command ->
            when (command) {
                is Back -> back()
                is BackTo -> backTo(command)
                is Forward -> forward(command)
                is Replace -> replace(command)
            }
        }
    }

    private fun back() = navigationController.back()

    private fun backTo(backTo: BackTo) {
        if (backTo.screen != null) {
            navigationController.backTo((backTo.screen as GoogleScreen).screenId())
        } else {
            navigationController.backTo(null)
        }
    }

    private fun forward(forward: Forward) =
        navigationController.nextScreen((forward.screen as GoogleScreen).screenId())

    private fun replace(replace: Replace) =
        navigationController.replace((replace.screen as GoogleScreen).screenId())
}