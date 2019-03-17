package com.yakow.weber.data.repository

import com.yakow.weber.data.prefs.PrefsProvider
import com.yakow.weber.data.system.schedulers.SchedulersProvider
import com.yakow.weber.domain.interactor.contract.MainContract
import javax.inject.Inject

/**
 * Created on 17.03.19
 * @author YWeber */

class MainRepository @Inject constructor(
    private val schedulers: SchedulersProvider,
    private val prefs: PrefsProvider
) : MainContract {
    override fun firsStart(firstStartDate: String) {
        prefs.launchFirsDate = firstStartDate
    }
}