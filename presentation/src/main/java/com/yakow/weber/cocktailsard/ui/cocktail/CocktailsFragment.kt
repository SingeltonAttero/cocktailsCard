package com.yakow.weber.cocktailsard.ui.cocktail

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.presenter.cocktail.CocktailsPresenter
import com.yakow.weber.cocktailsard.presenter.cocktail.CocktailsView
import com.yakow.weber.cocktailsard.toothpick.DI
import com.yakow.weber.cocktailsard.ui.base.BaseFragment
import com.yakow.weber.cocktailsard.ui.cocktail.adapter.CocktailsAdapter
import com.yakow.weber.domain.entity.Cocktail
import kotlinx.android.synthetic.main.fragment_cocktails.*
import org.jetbrains.anko.support.v4.toast
import toothpick.Toothpick

/**
 * Created on 24.03.19
 * @author YWeber */

class CocktailsFragment : BaseFragment(), CocktailsView {

    override val layoutRes: Int
        get() = R.layout.fragment_cocktails

    @InjectPresenter
    lateinit var presenter: CocktailsPresenter

    @ProvidePresenter
    fun providerPresenter(): CocktailsPresenter = Toothpick
        .openScope(DI.APP_SCOPE)
        .getInstance(CocktailsPresenter::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar?.title = getString(R.string.cocktail)
        initView()
    }

    private fun initView() {
        cocktailsRecycler.adapter = CocktailsAdapter(mutableListOf(), compositeDisposable)
        { item -> toast(item.toString()) }
        cocktailsRecycler.layoutManager = LinearLayoutManager(activity)
    }

    override fun setCocktails(list: List<Cocktail>) {
        (cocktailsRecycler.adapter as CocktailsAdapter).replaceData(list.toMutableList())
    }
}