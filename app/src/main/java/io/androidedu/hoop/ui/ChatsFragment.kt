package io.androidedu.hoop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.ChatListAdapter
import io.androidedu.hoop.db.ChatsDB
import io.androidedu.hoop.entity.ChatsEntity

import kotlinx.android.synthetic.main.fragment_chats.*
import kotlin.concurrent.thread

class ChatsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_chats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*
        with(recycChatList) {

            adapter = ChatListAdapter(GenerateDummyData.getDummyChatList()) { chatModel ->

                Toast.makeText(activity, "${chatModel.userName}", Toast.LENGTH_SHORT).show()
            }

            layoutManager = LinearLayoutManager(activity)
        }*/


        val chatsDB = ChatsDB.getInstance(activity!!)
        val chatsDao = chatsDB?.getChatsDao()

        val chatsEntity = ChatsEntity(
            userProfilPhoto = R.drawable.ic_man,
            userName = "Muammer Çakı",
            userMessage = "Kadının gözyaşlarından tüm dünya gebe kalsa",
            messageDate = "now"
        )

        thread(start = true) {
            chatsDao?.addNewItem(chatsEntity)
        }

        var allChatsList: List<ChatsEntity>?
        thread(start = true) {
            allChatsList = chatsDao?.getAllList()

            // Log.e("MainActivity",allChatsList!![1].userName)

            recycChatList.adapter = ChatListAdapter(allChatsList!!) {
                var newChatsList: List<ChatsEntity>? = null

                thread(start = true) {
                    newChatsList = chatsDao?.getAllList()!!
                }
            }
            recycChatList.layoutManager = LinearLayoutManager(activity!!)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ChatsFragment()
    }
}
