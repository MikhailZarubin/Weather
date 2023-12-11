package com.mzarubin.weather.model.datamodel

sealed class BaseEvent

data object CountriesRequestEvent: BaseEvent()
