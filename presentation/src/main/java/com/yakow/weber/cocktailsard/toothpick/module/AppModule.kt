package com.yakow.weber.cocktailsard.toothpick.module

import android.content.Context
import com.yakow.weber.cocktailsard.toothpick.system.ResourceManager
import com.yakow.weber.cocktailsard.toothpick.system.message.SystemMessageNotifier
import com.yakow.weber.data.prefs.AppPrefs
import com.yakow.weber.data.prefs.PrefsProvider
import com.yakow.weber.data.repository.CocktailsRepository
import com.yakow.weber.data.repository.MainRepository
import com.yakow.weber.data.system.executor.AppExecutors
import com.yakow.weber.data.system.executor.ExecutorsProvider
import com.yakow.weber.data.system.schedulers.AppSchedulers
import com.yakow.weber.data.system.schedulers.SchedulersProvider
import com.yakow.weber.domain.interactor.MainInteractor
import com.yakow.weber.domain.interactor.cocktail.CocktailsContractRepository
import com.yakow.weber.domain.interactor.contract.MainContract
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import timber.log.Timber
import toothpick.config.Module

/**
 * Created on 05.02.19
 * @author YWeber */

class AppModule(context: Context) : Module() {
    init {
        Timber.d("init app module")
        bind(Context::class.java).toInstance(context)
        bind(ResourceManager::class.java).toInstance(ResourceManager(context))
        bind(SchedulersProvider::class.java).toInstance(AppSchedulers())
        bind(ExecutorsProvider::class.java).toInstance(AppExecutors())
        bind(SystemMessageNotifier::class.java).toInstance(SystemMessageNotifier())
        bind(PrefsProvider::class.java).to(AppPrefs::class.java).singletonInScope()
        // main
        bind(MainContract::class.java).to(MainRepository::class.java)
        bind(MainInteractor::class.java).to(MainInteractor::class.java)
        Timber.d("cocktails init layer")
        bind(CocktailsContractRepository::class.java).to(CocktailsRepository::class.java)

        val cicerone = Cicerone.create()
        bind(Router::class.java).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).toInstance(cicerone.navigatorHolder)

    }
}