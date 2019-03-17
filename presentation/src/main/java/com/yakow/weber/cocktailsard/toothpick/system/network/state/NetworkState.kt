package com.yakow.weber.cocktailsard.toothpick.system.network.state

/**
 * Created on 05.03.19
 * @author YWeber */

sealed class NetworkState {
    object Loading : NetworkState()
    object Loaded : NetworkState()
    object Error : NetworkState()
}