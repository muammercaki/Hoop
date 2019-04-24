package io.androidedu.hoop.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.androidedu.hoop.dao.ChatsDao
import io.androidedu.hoop.entity.ChatsEntity


@Database(entities = [ChatsEntity::class], version = 4)
abstract class ChatsDB : RoomDatabase() {

    abstract fun getChatsDao(): ChatsDao

    companion object {
        private var INSTANCE: ChatsDB? = null

        fun getInstance(context: Context): ChatsDB? {
            if (INSTANCE == null) {
                synchronized(ChatsDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ChatsDB::class.java, "chats_table1"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}