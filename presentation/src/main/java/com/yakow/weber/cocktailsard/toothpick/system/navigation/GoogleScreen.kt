package com.yakow.weber.cocktailsard.toothpick.system.navigation

import androidx.annotation.IdRes
import ru.terrakok.cicerone.Screen

/**
 * Created on 14.06.19
 * @author YWeber */

abstract class GoogleScreen : Screen() {
    @IdRes
    abstract fun screenId(): Int
}