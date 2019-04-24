package io.androidedu.hoop.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StatusTable")

data class StatusEntity(

    @PrimaryKey(autoGenerate = true) @NonNull
    val id: Int = 0,

    @ColumnInfo(name = "statusProfilPhoto")
    val statusProfilPhoto: Int,

    @ColumnInfo(name = "statusUserName")
    val statusUserName: String,

    @ColumnInfo(name = "statusUserMessage")
    val statusUserMessage: String


)
