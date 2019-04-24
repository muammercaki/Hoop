package io.androidedu.hoop.dao

import androidx.room.*
import io.androidedu.hoop.entity.StatusEntity

@Dao
interface StatusDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)             //Ekleme
    fun addNewItem(statusDao: StatusEntity)

    @Delete
    fun removeItem(statusDao: StatusEntity)           //Remove

    @Update
    fun updateItem(statusDao: StatusEntity)    //Update

    @Query("SELECT * FROM StatusTable WHERE id LIKE :id ")
    fun findSingleItem(id: Int): StatusEntity

    @Query("SELECT * FROM StatusTable")              //tüm Tablo
    fun getAllList(): List<StatusEntity>

    @Query("DELETE  FROM StatusTable")    //Delete tüm tablo
    fun deleteAllTableList()
}