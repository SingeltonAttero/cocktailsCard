package com.yakow.weber.domain.interactor.cocktail

import com.yakow.weber.domain.entity.Cocktail
import com.yakow.weber.domain.state.CocktailPartialState
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created on 02.04.19
 * @author YWeber */

class CocktailsInteractor @Inject constructor(private val repository: CocktailsContractRepository) {

    fun firstPageCocktails(): Observable<out CocktailPartialState> = Single.fromCallable {
        addCocktailsDay()
    }.map<CocktailPartialState> { CocktailPartialState.FirstCocktailList(it) }
        .toObservable()

    private fun addCocktailsDay(): List<Cocktail> {
        val cocktailsTheDay = repository.cocktailsTheDay
        val cocktails = repository.cocktails.toMutableList()
        cocktails.add(cocktailsTheDay)
        return cocktails.sortedBy { !it.dayCocktail }
    }
}