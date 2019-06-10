package com.yakow.weber.domain.state

import com.yakow.weber.domain.entity.Cocktail

/**
 * Created on 11.06.19
 * @author YWeber */

sealed class CocktailPartialState {
    data class FirstCocktailList(val cocktail: List<Cocktail>):CocktailPartialState()
}