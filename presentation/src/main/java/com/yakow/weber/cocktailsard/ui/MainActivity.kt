package com.yakow.weber.cocktailsard.ui

import android.os.Bundle
import androidx.navigation.Navigation
import com.hannesdorfmann.mosby3.mvi.MviActivity
import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.presenter.MainPresenter
import com.yakow.weber.cocktailsard.presenter.MainView
import com.yakow.weber.cocktailsard.toothpick.DI
import com.yakow.weber.cocktailsard.toothpick.system.navigation.GoogleNavigationController
import com.yakow.weber.cocktailsard.toothpick.system.navigation.GraphNavigator
import kotlinx.android.synthetic.main.toolbar.*
import ru.terrakok.cicerone.NavigatorHolder
import toothpick.Toothpick
import javax.inject.Inject

class MainActivity : MviActivity<MainView, MainPresenter>(), MainView {
    override fun render(viewState: String) {
        //TODO Content
    }

    override fun createPresenter(): MainPresenter =  Toothpick
            .openScope(DI.APP_SCOPE)
            .getInstance(MainPresenter::class.java)

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    private val graphNavigator
        get() = GraphNavigator(navigationControllerProvider)

    private val navigationControllerProvider
        get() = GoogleNavigationController(
            Navigation.findNavController(
                this,
                R.id.mainNavHostFragment
            )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        val appScope = Toothpick.openScope(DI.APP_SCOPE)
        Toothpick.inject(this, appScope)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(graphNavigator)
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }
}
