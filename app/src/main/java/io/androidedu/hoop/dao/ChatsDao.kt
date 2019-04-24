package io.androidedu.hoop.dao

import androidx.room.*
import io.androidedu.hoop.entity.ChatsEntity


@Dao
interface ChatsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)             //Ekleme
    fun addNewItem(chatsDao: ChatsEntity)

    @Delete
    fun removeItem(chatsDao: ChatsEntity)           //Remove

    @Update
    fun updateItem(chatsDao: ChatsEntity)    //Update

    @Query("SELECT * FROM chats_table WHERE id LIKE :id ")
    fun findSingleItem(id: Int): ChatsEntity

    @Query("SELECT * FROM chats_table")              //tüm Tablo
    fun getAllList(): List<ChatsEntity>

    @Query("DELETE  FROM chats_table")    //Delete tüm tablo
    fun deleteAllTableList()
}