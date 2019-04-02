package com.yakow.weber.domain.mock

import com.yakow.weber.domain.entity.Cocktail

object MockData {

    val cocktails: List<Cocktail> = getCocktailsMock().sortedBy { !it.dayCocktail }

    private fun getCocktailsMock(): MutableList<Cocktail> {
        val mutableListOf = mutableListOf<Cocktail>()
        for (i in 0..100) {
            var name = if (i % 2 == 1) "Самый клубничный милкшейк" else "Клубничный милкшейк"
            var cocktail = Cocktail(
                name,
                "Клубника, молоко,  лед, земляника ",
                "10 - 15 мин", "https://cdn.liquor.com/wp-content/uploads/2017/11/14145228/bacardi-cocktail-720x720-recipe.jpg",
                0,
                favorites = i % 3 == 0, tested = i % 2 == 0, dayCocktail = false
            )

            if (i == 3) {
                name = "Топ 1"
                cocktail = Cocktail(
                    name,
                    "Сахар, лед,  вода, тесто ",
                    "120 - 151 мин", "https://typobar.ru/files/blog/2017/2017-11-27-samye_ubiystvennye_alkogolnye_kokteyli_recepty_dlya_smelyh.jpg",
                    2,
                    favorites = i % 3 == 0, tested = i % 2 == 0, dayCocktail = true
                )
            }
            mutableListOf.add(cocktail)
        }
        return mutableListOf
    }

}