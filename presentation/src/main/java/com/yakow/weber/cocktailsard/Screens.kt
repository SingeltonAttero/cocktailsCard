package com.yakow.weber.cocktailsard

import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.toothpick.system.navigation.GoogleScreen

object Screens {
    object ScreenToFavorite : GoogleScreen() {
        override fun screenId(): Int = R.id.favoriteFragmentMain
    }
}