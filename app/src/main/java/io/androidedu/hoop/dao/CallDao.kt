package io.androidedu.hoop.dao

import androidx.room.*
import io.androidedu.hoop.entity.CallEntity

@Dao
interface CallDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)             //Ekleme
    fun addNewItem(callDao: CallEntity)

    @Delete
    fun removeItem(callDao: CallEntity)           //Remove

    @Update
    fun updateItem(callDao: CallEntity)    //Update

    @Query("SELECT * FROM CallTable WHERE _id LIKE :id ")
    fun findSingleItem(id: Int): CallEntity

    @Query("SELECT * FROM CallTable")              //tüm Tablo
    fun getAllList(): List<CallEntity>

    @Query("DELETE  FROM CallTable")    //Delete tüm tablo
    fun deleteAllTableList()
}