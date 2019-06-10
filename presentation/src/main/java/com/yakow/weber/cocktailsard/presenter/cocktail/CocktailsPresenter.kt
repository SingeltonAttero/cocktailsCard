package com.yakow.weber.cocktailsard.presenter.cocktail

import com.yakow.weber.cocktailsard.extension.printConstruction
import com.yakow.weber.cocktailsard.presenter.base.BasePresenter
import com.yakow.weber.domain.interactor.cocktail.CocktailsInteractor
import com.yakow.weber.domain.state.CocktailPartialState
import com.yakow.weber.domain.state.CocktailViewState
import io.reactivex.functions.BiFunction
import javax.inject.Inject

/**
 * Created on 02.04.19
 * @author YWeber */
class CocktailsPresenter @Inject constructor(private val interactor: CocktailsInteractor) :
    BasePresenter<CocktailsView, CocktailViewState>() {
    init {
        printConstruction()
    }

    override fun bindIntents() {
        val firstCocktailsIntent = intent(CocktailsView::getFirsCocktailList)
            .flatMap {
                interactor.firstPageCocktails()
            }
        val initViewState = CocktailViewState(listOf())
        val distinctUntilChanged =
            firstCocktailsIntent.scan(initViewState, reducer).distinctUntilChanged()
        subscribeViewState(distinctUntilChanged, CocktailsView::render)

    }

    private val reducer =
        BiFunction { oldViewState: CocktailViewState, partial: CocktailPartialState ->
            when (partial) {
                is CocktailPartialState.FirstCocktailList -> oldViewState.copy(partial.cocktail)
            }
        }
}