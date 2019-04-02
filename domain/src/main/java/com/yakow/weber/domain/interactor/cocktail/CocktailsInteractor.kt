package com.yakow.weber.domain.interactor.cocktail

import com.yakow.weber.domain.entity.Cocktail
import javax.inject.Inject

/**
 * Created on 02.04.19
 * @author YWeber */

class CocktailsInteractor @Inject constructor(private val repository: CocktailsContract) {
    val cocktails: List<Cocktail>
        get() = addCocktailsDay()

    private fun addCocktailsDay(): List<Cocktail> {
        val cocktailsTheDay = repository.cocktailsTheDay
        val cocktails = repository.cocktails.toMutableList()
        cocktails.add(cocktailsTheDay)
        return cocktails.sortedBy { !it.dayCocktail }
    }
}