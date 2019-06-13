package com.yakow.weber.cocktailsard.toothpick.system.navigation

/**
 * Created on 14.06.19
 * @author YWeber */

interface NavigationControllerProvider {
    fun nextScreen(screenId: Int)
    fun back()
    fun backTo(screenId: Int?)
    fun replace(screenId: Int)
}