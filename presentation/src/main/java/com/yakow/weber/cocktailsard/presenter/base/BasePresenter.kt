package com.yakow.weber.cocktailsard.presenter.base

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import com.yakow.weber.cocktailsard.toothpick.system.disposable.ComponentDisposables
import com.yakow.weber.cocktailsard.toothpick.system.disposable.ComponentDisposablesProvider

/**
 * Created on 05.02.19
 * @author YWeber */
abstract class BasePresenter<V : MviBaseView<*>, VS> : MviBasePresenter<V, VS>(),
    ComponentDisposablesProvider by ComponentDisposables() {
    override fun unbindIntents() {
        clear()
        super.unbindIntents()
    }
}