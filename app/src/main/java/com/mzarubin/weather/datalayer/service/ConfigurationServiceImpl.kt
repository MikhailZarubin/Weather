package com.mzarubin.weather.datalayer.service

import android.annotation.SuppressLint
import android.content.SharedPreferences
import javax.inject.Inject

class ConfigurationServiceImpl @Inject constructor(
    private val sharedPreference: SharedPreferences
) : ConfigurationService {

    override fun getUseCurrentCoordinatesProperty(): Boolean {
        return sharedPreference.getBoolean(USE_CURRENT_COORDINATES_KEY, false)
    }

    @SuppressLint("CommitPrefEdits")
    override fun setUseCurrentCoordinatesProperty(useCurrentCoordinates: Boolean) {
        sharedPreference.edit().apply {
            putBoolean(USE_CURRENT_COORDINATES_KEY, useCurrentCoordinates)
            apply()
        }
    }

    private companion object {
        const val USE_CURRENT_COORDINATES_KEY = "use_current_coordinates"
    }
}
