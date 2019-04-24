package io.androidedu.hoop.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.androidedu.hoop.dao.StatusDao
import io.androidedu.hoop.entity.StatusEntity

@Database(entities = [StatusEntity::class], version = 4)
abstract class StatusDB : RoomDatabase() {
    abstract fun getStatusDao(): StatusDao

    companion object {
        private var INSTANCE: StatusDB? = null

        fun getInstance(context: Context): StatusDB? {
            if (INSTANCE == null) {
                synchronized(StatusDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        StatusDB::class.java, "StatusTable1"
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