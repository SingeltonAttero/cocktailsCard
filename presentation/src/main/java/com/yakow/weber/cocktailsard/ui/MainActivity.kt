package com.yakow.weber.cocktailsard.ui

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.presenter.MainPresenter
import com.yakow.weber.cocktailsard.presenter.MainView
import com.yakow.weber.cocktailsard.toothpick.DI
import com.yakow.weber.cocktailsard.toothpick.system.androidx.MvpAppCompatActivity
import org.jetbrains.anko.toast
import toothpick.Toothpick

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providerPresenter() = Toothpick
        .openScope(DI.APP_SCOPE)
        .getInstance(MainPresenter::class.java)

    override fun showErrorToast(message: String) {
        toast(message)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
