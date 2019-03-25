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
        val mutableListOf = mutableListOf<Cocktail>()
        for (i in 0..100){
            val cocktail = Cocktail("Клубничный милкшейк ",
                    "Клубника, молоко,  лед, земляника ",
                    "10 - 15 мин", "", 0,
                    favorites = false, tested = false)
            mutableListOf.add(cocktail)
        }
        cocktailsRecycler.adapter = CocktailsAdapter(mutableListOf)
        cocktailsRecycler.layoutManager = LinearLayoutManager(activity)

    }
}