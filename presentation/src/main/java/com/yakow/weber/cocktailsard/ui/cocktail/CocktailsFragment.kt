package com.yakow.weber.cocktailsard.ui.cocktail

import android.os.Bundle
import android.view.View
import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.ui.base.BaseFragment

/**
 * Created on 24.03.19
 * @author YWeber */

class CocktailsFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_cocktails

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar?.title = getString(R.string.cocktail)
    }
}