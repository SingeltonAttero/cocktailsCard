package com.yakow.weber.cocktailsard.toothpick.system.message

import com.yakow.weber.cocktailsard.toothpick.system.message.SystemMessageType

/**
 * Created on 22.02.19
 * @author YWeber */

data class SystemMessage (
    val message: String,
    val type: SystemMessageType = SystemMessageType.TOAST
)