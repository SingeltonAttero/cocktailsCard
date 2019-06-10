package com.yakow.weber.cocktailsard.ui

import android.os.Bundle
import com.hannesdorfmann.mosby3.mvi.MviActivity
import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.presenter.MainPresenter
import com.yakow.weber.cocktailsard.presenter.MainView
import com.yakow.weber.cocktailsard.toothpick.DI
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.toast
import toothpick.Toothpick

class MainActivity : MviActivity<MainView, MainPresenter>(), MainView {
    override fun render(viewState: String) {
        //TODO Content
    }

    override fun createPresenter(): MainPresenter =  Toothpick
            .openScope(DI.APP_SCOPE)
            .getInstance(MainPresenter::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }
}
