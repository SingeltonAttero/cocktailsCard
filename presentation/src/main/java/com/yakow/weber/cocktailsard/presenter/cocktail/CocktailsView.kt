package com.yakow.weber.cocktailsard.presenter.cocktail

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.yakow.weber.domain.entity.Cocktail

/**
 * Created on 02.04.19
 * @author YWeber */
@StateStrategyType(value = AddToEndSingleStrategy::class)
interface CocktailsView : MvpView {
    fun setCocktails(list: List<Cocktail>)
}