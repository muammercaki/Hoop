package io.androidedu.hoop.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "chats_table")
data class ChatsEntity(

    @PrimaryKey(autoGenerate = true)
    val userProfilPhoto: Int,

    @ColumnInfo(name = "userName")
    val userName: String,

    @ColumnInfo(name = "userMessage")
    val userMessage: String,

    @ColumnInfo(name = "messageDate")
    val messageDate: String

)