package com.yakow.weber.data.repository

import com.yakow.weber.domain.entity.Cocktail
import com.yakow.weber.domain.interactor.cocktail.CocktailsContractRepository
import com.yakow.weber.domain.mock.MockData
import javax.inject.Inject

/**
 * Created on 02.04.19
 * @author YWeber */

class CocktailsRepository @Inject constructor() : CocktailsContractRepository {

    override val cocktails: List<Cocktail>
        get() = MockData.cocktails.filter { !it.dayCocktail }

    override val cocktailsTheDay: Cocktail
        get() = MockData.cocktails.first { it.dayCocktail }
}