package com.yakow.weber.cocktailsard.presenter

import com.arellomobile.mvp.MvpView

/**
 * Created on 17.03.19
 * @author YWeber */

interface MainView : MvpView{
    fun showErrorToast(message:String)
}