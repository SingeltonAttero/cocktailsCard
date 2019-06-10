package com.yakow.weber.cocktailsard.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.hannesdorfmann.mosby3.mvi.MviFragment
import com.yakow.weber.cocktailsard.presenter.base.BasePresenter
import com.yakow.weber.cocktailsard.presenter.base.MviBaseView
import com.yakow.weber.cocktailsard.toothpick.system.disposable.ComponentDisposables
import com.yakow.weber.cocktailsard.toothpick.system.disposable.ComponentDisposablesProvider

/**
 * Created on 13.02.19
 * @author YWeber */

abstract class BaseFragment<V : MviBaseView<*>, P : BasePresenter<V, *>> : MviFragment<V, P>(),
    ComponentDisposablesProvider by ComponentDisposables() {

    abstract val layoutRes: Int @LayoutRes get

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onDestroy() {
        clear()
        super.onDestroy()
    }
}