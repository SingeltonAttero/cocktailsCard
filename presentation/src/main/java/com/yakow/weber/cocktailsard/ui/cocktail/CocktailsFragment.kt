package com.yakow.weber.cocktailsard.ui.cocktail

import android.os.Bundle
import android.view.View
import androidx.transition.TransitionManager
import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.presenter.cocktail.CocktailsPresenter
import com.yakow.weber.cocktailsard.presenter.cocktail.CocktailsView
import com.yakow.weber.cocktailsard.toothpick.DI
import com.yakow.weber.cocktailsard.ui.base.BaseFragment
import com.yakow.weber.cocktailsard.ui.cocktail.adapter.CocktailsAdapter
import com.yakow.weber.domain.state.CocktailViewState
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_cocktails.*
import org.jetbrains.anko.support.v4.toast
import toothpick.Toothpick

/**
 * Created on 24.03.19
 * @author YWeber */

class CocktailsFragment : BaseFragment<CocktailsView, CocktailsPresenter>(), CocktailsView {

    override val layoutRes: Int
        get() = R.layout.fragment_cocktails

    private val adapter by lazy {
        CocktailsAdapter(mutableListOf(), compositeDisposable) { item -> toast("$item") }
    }

    override fun createPresenter(): CocktailsPresenter = Toothpick
        .openScope(DI.APP_SCOPE)
        .getInstance(CocktailsPresenter::class.java)

    override fun render(viewState: CocktailViewState) {
        TransitionManager.beginDelayedTransition(cocktailsRecycler)
        adapter.replaceData(viewState.cocktailList)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cocktailsRecycler.adapter = adapter
    }

    override fun getFirsCocktailList(): Observable<Boolean> = Observable.just(true)



}