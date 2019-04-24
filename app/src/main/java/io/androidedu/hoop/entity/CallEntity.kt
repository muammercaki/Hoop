package io.androidedu.hoop.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CallTable")
data class CallEntity(

    @PrimaryKey(autoGenerate = true) @NonNull
    val _id: Int = 0,

    @ColumnInfo(name = "callProfilPhoto")
    val callProfilPhoto: Int,

    @ColumnInfo(name = "callUserName")
    val callUserName: String,


    @ColumnInfo(name = "callMessageDate")
    val callMessageDate: String,

    @ColumnInfo(name = "callPhoneIcon")
    val callPhoneIcon: Int

)
