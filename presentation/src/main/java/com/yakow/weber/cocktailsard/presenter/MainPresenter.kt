package com.yakow.weber.cocktailsard.presenter

import com.arellomobile.mvp.InjectViewState
import com.yakow.weber.cocktailsard.presenter.base.BasePresenter
import com.yakow.weber.cocktailsard.toothpick.system.message.SystemMessageNotifier
import com.yakow.weber.domain.interactor.MainInteractor
import javax.inject.Inject

/**
 * Created on 17.03.19
 * @author YWeber */
@InjectViewState
class MainPresenter @Inject constructor(
    private val systemMessage: SystemMessageNotifier,
    private val interactor: MainInteractor
) : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showErrorToast("test")

    }

}