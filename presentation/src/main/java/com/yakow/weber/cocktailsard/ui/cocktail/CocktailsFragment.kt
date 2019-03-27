package com.yakow.weber.cocktailsard.ui.cocktail

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.ui.base.BaseFragment
import com.yakow.weber.cocktailsard.ui.cocktail.adapter.CocktailsAdapter
import com.yakow.weber.domain.entity.Cocktail
import kotlinx.android.synthetic.main.fragment_cocktails.*

/**
 * Created on 24.03.19
 * @author YWeber */

class CocktailsFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_cocktails

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar?.title = getString(R.string.cocktail)
        mockData()

    }

    private fun mockData() {
        val mutableListOf = mutableListOf<Cocktail>()
        for (i in 0..100) {
            val name = if (i % 2 == 1)  "Самый клубничный милкшейк" else "Клубничный милкшейк"
            val cocktail = Cocktail(name,
                    "Клубника, молоко,  лед, земляника ",
                    "10 - 15 мин", "", 0,
                    favorites = i % 3 == 0, tested = i % 2 == 0)
            mutableListOf.add(cocktail)
        }
        cocktailsRecycler.adapter = CocktailsAdapter(mutableListOf)
        cocktailsRecycler.layoutManager = LinearLayoutManager(activity)
    }
}