package com.yakow.weber.domain.interactor.cocktail

import com.yakow.weber.domain.entity.Cocktail

/**
 * Created on 02.04.19
 * @author YWeber */

interface CocktailsContract {
    val cocktails: List<Cocktail>
    val cocktailsTheDay: Cocktail
}