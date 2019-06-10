package com.yakow.weber.cocktailsard.presenter.base

import com.hannesdorfmann.mosby3.mvp.MvpView

/**
 * Created on 11.06.19
 * @author YWeber */

interface MviBaseView<T> : MvpView {
    fun render(viewState: T)
}