package com.yakow.weber.cocktailsard

import android.app.Application
import com.yakow.weber.cocktailsard.toothpick.DI
import com.yakow.weber.cocktailsard.toothpick.module.AppModule
import net.danlew.android.joda.JodaTimeAndroid
import timber.log.Timber
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator

/**
 * Created on 24.02.19
 * @author YWeber */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        JodaTimeAndroid.init(this)
        initLogger()
        initToothpick()
        initScope()
    }

    private fun initScope() {
        val appScope = Toothpick.openScope(DI.APP_SCOPE)
        appScope.installModules(AppModule(this))
    }

    private fun initToothpick() {
        if (BuildConfig.DEBUG) {
            Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
        } else {
            Toothpick.setConfiguration(Configuration.forProduction().disableReflection())
            FactoryRegistryLocator.setRootRegistry(com.yakow.weber.cocktailsard.FactoryRegistry())
            MemberInjectorRegistryLocator.setRootRegistry(com.yakow.weber.cocktailsard.MemberInjectorRegistry())
        }
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}