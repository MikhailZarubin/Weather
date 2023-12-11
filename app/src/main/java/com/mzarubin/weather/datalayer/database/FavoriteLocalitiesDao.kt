package com.mzarubin.weather.datalayer.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mzarubin.weather.datalayer.datamodel.LocalityEntity

@Dao
interface FavoriteLocalitiesAcceptorDao {

    @Insert(onConflict = OnConflictStrategy.NONE)
    fun insertFavoriteLocality(localityEntity: LocalityEntity)

    @Delete
    fun deleteFavoriteLocality(localityEntity: LocalityEntity)
}

@Dao
interface FavoriteLocalitiesSourceDao {

    @Query("SELECT * FROM locality")
    fun getFavoriteLocalities(): List<LocalityEntity>
}
