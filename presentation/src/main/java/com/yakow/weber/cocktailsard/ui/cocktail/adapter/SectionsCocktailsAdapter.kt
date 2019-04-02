package com.yakow.weber.cocktailsard.ui.cocktail.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yakow.weber.cocktailsard.ui.cocktail.CocktailsFragment

/**
 * Created on 28.03.19
 * @author YWeber */
private const val SIZE_FRAGMENT_COCKTAILS = 2

class SectionsCocktailsAdapter(
    fragmentManager: FragmentManager,
    private val titleTab: (position: Int) -> String
) :
    FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment = when (position) {
        0 -> CocktailsFragment()
        else -> CocktailsFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> titleTab(position)
            else -> titleTab(position)
        }
    }

    override fun getCount(): Int = SIZE_FRAGMENT_COCKTAILS

}