package com.yakow.weber.cocktailsard.ui.cocktail.tabs

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayout
import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.ui.base.BaseFragment
import com.yakow.weber.cocktailsard.ui.cocktail.adapter.SectionsCocktailsAdapter
import kotlinx.android.synthetic.main.fragmen_cocktails_sections.*

/**
 * Created on 28.03.19
 * @author YWeber */

class SectionsCocktailsFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragmen_cocktails_sections

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cocktailsTabs.addTab(cocktailsTabs.newTab().setText("Лонгдринки"))
        cocktailsTabs.addTab(cocktailsTabs.newTab().setText("Шоты"))
        cocktailsPager.adapter = SectionsCocktailsAdapter(childFragmentManager)
        cocktailsPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(cocktailsTabs))
    }
}