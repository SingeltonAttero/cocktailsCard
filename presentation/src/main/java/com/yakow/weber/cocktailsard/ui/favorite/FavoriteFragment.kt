package com.yakow.weber.cocktailsard.ui.favorite

import android.os.Bundle
import android.view.View
import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.presenter.favorite.FavoritePresenter
import com.yakow.weber.cocktailsard.presenter.favorite.FavoriteView
import com.yakow.weber.cocktailsard.ui.base.BaseFragment
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created on 24.03.19
 * @author YWeber */

class FavoriteFragment : BaseFragment<FavoriteView, FavoritePresenter>(), FavoriteView {
    override val layoutRes: Int
        get() = R.layout.fragment_favorite

    override fun createPresenter(): FavoritePresenter = FavoritePresenter()

    override fun render(viewState: String) {
        // TODO content
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar?.title = getString(R.string.favorites)
    }
}