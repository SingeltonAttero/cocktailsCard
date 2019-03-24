package com.yakow.weber.cocktailsard.ui.consist

import android.os.Bundle
import android.view.View
import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.ui.base.BaseFragment

/**
 * Created on 24.03.19
 * @author YWeber */

class ConsistsFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_consists

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar?.title = getString(R.string.select_consist)
    }
}