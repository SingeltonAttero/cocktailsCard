package com.yakow.weber.cocktailsard.ui.cocktail.tabs

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayout
import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.presenter.cocktail.tabs.SectionCocktailsPresenter
import com.yakow.weber.cocktailsard.presenter.cocktail.tabs.SectionCocktailsView
import com.yakow.weber.cocktailsard.ui.base.BaseFragment
import com.yakow.weber.cocktailsard.ui.cocktail.adapter.SectionsCocktailsAdapter
import kotlinx.android.synthetic.main.fragmen_cocktails_sections.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created on 28.03.19
 * @author YWeber */

class SectionsCocktailsFragment : BaseFragment<SectionCocktailsView, SectionCocktailsPresenter>(),
    SectionCocktailsView {

    override fun createPresenter(): SectionCocktailsPresenter = SectionCocktailsPresenter()

    override val layoutRes: Int
        get() = R.layout.fragmen_cocktails_sections

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.setTitle(R.string.cocktail)
        cocktailsTabs.setupWithViewPager(cocktailsPager)
        cocktailsPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(cocktailsTabs))
        cocktailsPager.adapter = SectionsCocktailsAdapter(childFragmentManager)
        { position -> tabTitle(position) }
    }

    private fun tabTitle(position: Int): String = when (position) {
        0 -> getString(R.string.long_drink)
        else -> getString(R.string.shots)
    }

    override fun render(viewState: String) {
            //TODO VIEW CONTENT
        }
}