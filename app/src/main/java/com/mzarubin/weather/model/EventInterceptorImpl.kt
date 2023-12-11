package com.mzarubin.weather.model

import com.mzarubin.weather.model.datamodel.BaseEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import timber.log.Timber

class EventInterceptorImpl : EventInterceptor {

    private val eventFlow: MutableSharedFlow<BaseEvent> = MutableSharedFlow()

    override suspend fun onEvent(event: BaseEvent) {
        eventFlow.emit(event)
        Timber.d("onEvent $event")
    }

    override fun getEvents(): SharedFlow<BaseEvent> {
        return eventFlow.asSharedFlow()
    }
}
