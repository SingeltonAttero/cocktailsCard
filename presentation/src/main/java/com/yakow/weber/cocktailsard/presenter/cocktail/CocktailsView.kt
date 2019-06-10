package com.yakow.weber.cocktailsard.presenter.cocktail

import com.yakow.weber.cocktailsard.presenter.base.MviBaseView
import com.yakow.weber.domain.entity.Cocktail
import com.yakow.weber.domain.state.CocktailViewState
import io.reactivex.Observable

/**
 * Created on 02.04.19
 * @author YWeber */

interface CocktailsView : MviBaseView<CocktailViewState> {
    fun getFirsCocktailList(): Observable<Boolean>

}