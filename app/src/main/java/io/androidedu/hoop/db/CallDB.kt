package io.androidedu.hoop.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.androidedu.hoop.dao.CallDao
import io.androidedu.hoop.entity.CallEntity


@Database(entities = [CallEntity::class], version = 7)
abstract class CallDB : RoomDatabase() {

    abstract fun getCallDao(): CallDao

    companion object {
        private var INSTANCE: CallDB? = null

        fun getInstance(context: Context): CallDB? {
            if (INSTANCE == null) {
                synchronized(CallDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CallDB::class.java, "CallTable"
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