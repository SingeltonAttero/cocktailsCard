package com.yakow.weber.cocktailsard.presenter

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created on 17.03.19
 * @author YWeber */
@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView{
    fun showErrorToast(message:String)
}