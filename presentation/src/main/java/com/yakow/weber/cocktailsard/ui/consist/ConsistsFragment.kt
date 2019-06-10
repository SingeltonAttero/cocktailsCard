package com.yakow.weber.cocktailsard.ui.consist

import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.presenter.consist.ConsistPresenter
import com.yakow.weber.cocktailsard.presenter.consist.ConsistView
import com.yakow.weber.cocktailsard.ui.base.BaseFragment

/**
 * Created on 24.03.19
 * @author YWeber */

class ConsistsFragment : BaseFragment<ConsistView, ConsistPresenter>() {
    override fun createPresenter(): ConsistPresenter = ConsistPresenter()

    override val layoutRes: Int
        get() = R.layout.fragment_consists

}