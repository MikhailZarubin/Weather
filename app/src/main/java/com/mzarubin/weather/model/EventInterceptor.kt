package com.mzarubin.weather.model

import com.mzarubin.weather.model.datamodel.BaseEvent
import kotlinx.coroutines.flow.SharedFlow

interface EventInterceptor {

    suspend fun onEvent(event: BaseEvent)

    fun getEvents(): SharedFlow<BaseEvent>
}
