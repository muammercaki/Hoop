package io.androidedu.hoop.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.androidedu.hoop.dao.CallDao
import io.androidedu.hoop.dao.ChatsDao
import io.androidedu.hoop.dao.StatusDao
import io.androidedu.hoop.entity.CallEntity
import io.androidedu.hoop.entity.ChatsEntity
import io.androidedu.hoop.entity.StatusEntity


@Database(entities = [ChatsEntity::class, CallEntity::class, StatusEntity::class], version = 5)
abstract class AppDB : RoomDatabase() {

    abstract fun getChatsDao(): ChatsDao
    abstract fun getCallDao(): CallDao
    abstract fun getStatusDao(): StatusDao

    companion object {
        private var INSTANCE: AppDB? = null

        fun getInstance(context: Context): AppDB? {
            if (INSTANCE == null) {
                synchronized(AppDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDB::class.java,
                        "chats_table2"
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