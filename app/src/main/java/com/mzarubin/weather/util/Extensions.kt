package com.mzarubin.weather.util

import com.mzarubin.weather.domainlayer.datamodel.CoordinatesDataModel
import com.mzarubin.weather.domainlayer.datamodel.LocalityDataModel
import com.mzarubin.weather.domainlayer.datamodel.Location

fun Location.getId(): Int {
    return when (this) {
        is CoordinatesDataModel -> ID_UNDEFINED_LOCALITY
        is LocalityDataModel -> localityName.hashCode()
    }
}

fun Location.getName(): String {
    return when (this) {
        is CoordinatesDataModel -> "${latitude}_${longitude}"
        is LocalityDataModel -> localityName
    }
}
