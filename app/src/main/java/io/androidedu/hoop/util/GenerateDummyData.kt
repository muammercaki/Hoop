package io.androidedu.hoop.util

import io.androidedu.hoop.R
import io.androidedu.hoop.model.ChatModel

object GenerateDummyData {

    fun getDummyChatList(): ArrayList<ChatModel> = ArrayList<ChatModel>().apply {

        val chatModel = ChatModel(
            R.drawable.ic_man,
            "Muammer Çakı",
            "Merhaba, geldim ben sen nerdesin!!",
                "Yesterday")


        for (i in 0..50) {
            add(
                ChatModel(
                    R.drawable.ic_man,
                    "Muammer Çakı " + i,
                    "Merhaba, geldim ben sen nerdesin!! " + i,
                    "Yesterday"
                )
            )
        }

    }
}