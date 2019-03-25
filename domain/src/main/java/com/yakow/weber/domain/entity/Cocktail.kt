package com.yakow.weber.domain.entity

/**
 * Created on 26.03.19
 * @author YWeber */

data class Cocktail(
    val nameCocktail: String,
    val consist: String,
    val timePreparing: String,
    val pictureCocktail: String,
    val rating: Int,
    val favorites: Boolean,
    val tested: Boolean
)