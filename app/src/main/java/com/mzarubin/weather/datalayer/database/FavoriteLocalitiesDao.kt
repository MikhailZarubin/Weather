package com.mzarubin.weather.datalayer.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mzarubin.weather.datamodel.LocalityEntity

@Dao
interface FavoriteLocalitiesDao {

    @Insert
    fun insertFavoriteLocalities(vararg localityEntity: LocalityEntity)

    @Query("SELECT * FROM locality")
    fun getFavoriteLocalities(): List<LocalityEntity>
}
