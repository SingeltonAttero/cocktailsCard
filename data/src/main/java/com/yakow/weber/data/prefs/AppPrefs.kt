package com.yakow.weber.data.prefs

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import javax.inject.Inject

/**
 * Created on 17.03.19
 * @author YWeber */

class AppPrefs @Inject constructor(private val context: Context) : PrefsProvider {

    companion object {
        private const val FIRST_LAUNCH = "first launch date"
    }

    private inline fun SharedPreferences.edit(block: SharedPreferences.Editor.() -> Unit) {
        edit().apply { block() }.apply()
    }

    private val sharedPrefs
            by lazy { PreferenceManager.getDefaultSharedPreferences(context) }

    override var launchFirsDate: String
        get() = sharedPrefs.getString(FIRST_LAUNCH, "") ?: ""
        set(value) {
            sharedPrefs.edit { putString(FIRST_LAUNCH, value) }
        }
}