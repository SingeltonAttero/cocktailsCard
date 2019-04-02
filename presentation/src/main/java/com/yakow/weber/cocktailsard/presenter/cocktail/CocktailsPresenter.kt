package com.yakow.weber.cocktailsard.presenter.cocktail

import com.arellomobile.mvp.InjectViewState
import com.yakow.weber.cocktailsard.extension.printConstruction
import com.yakow.weber.cocktailsard.presenter.base.BasePresenter
import com.yakow.weber.domain.interactor.cocktail.CocktailsInteractor
import javax.inject.Inject

/**
 * Created on 02.04.19
 * @author YWeber */
@InjectViewState
class CocktailsPresenter @Inject constructor(private val interactor: CocktailsInteractor) :
    BasePresenter<CocktailsView>() {
    init {
        printConstruction()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setCocktails(interactor.cocktails)
    }
}