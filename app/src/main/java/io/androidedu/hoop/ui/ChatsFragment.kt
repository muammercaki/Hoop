package io.androidedu.hoop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.ChatListAdapter
import io.androidedu.hoop.db.AppDB
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

        val chatsDB = AppDB.getInstance(activity!!)
        val chatsDao = chatsDB?.getChatsDao()


        with(recycChatList) {
            adapter = ChatListAdapter { _chatListEntity ->
                thread(start = true) {
                    chatsDao?.removeItem(_chatListEntity)
                }
            }
            layoutManager = LinearLayoutManager(activity)
        }
        chatsDao?.getAllList()?.observe(this, Observer<List<ChatsEntity>> { _newChatList ->
            (recycChatList.adapter as ChatListAdapter).setNewItem(_newChatList)

        })


        val chatsEntity = ChatsEntity(
            userProfilPhoto = R.drawable.ic_man,
            userName = "Muammer Çakı",
            userMessage = "Kadının gözyaşlarından tüm dünya gebe kalsa",
            messageDate = "now"
        )
        thread(start = true) {
            chatsDao?.addNewItem(chatsEntity)
        }
/*
        thread(start = true) {
            chatsDao?.addNewItem(chatsEntity)
        }

        recycChatList.layoutManager = LinearLayoutManager(activity!!)

        var allChatsList: List<ChatsEntity>?

        thread(start = true) {
            allChatsList = chatsDao?.getAllList()

            // Log.e("MainActivity",allChatsList!![1].userName)

            activity!!.runOnUiThread {
                recycChatList.adapter = ChatListAdapter(allChatsList!!) {

                }
            }

        }
    }*/
    }

    companion object {
        @JvmStatic
        fun newInstance() = ChatsFragment()
    }
}
