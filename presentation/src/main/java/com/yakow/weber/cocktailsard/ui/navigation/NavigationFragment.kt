package com.yakow.weber.cocktailsard.ui.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_navigation.*

/**
 * Created on 22.03.19
 * @author YWeber */

class NavigationFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_navigation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navigator = Navigation.findNavController(context as FragmentActivity, R.id.innerNavHostFragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navigator)
    }
}