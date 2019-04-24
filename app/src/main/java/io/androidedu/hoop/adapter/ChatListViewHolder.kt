package io.androidedu.hoop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.R
import io.androidedu.hoop.entity.ChatsEntity

class ChatListViewHolder(parent: ViewGroup)

    : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(
        R.layout.adapter_item_chat_list, parent,
        false
    )
) {
    private val imgProfile: ImageView by lazy { itemView.findViewById<ImageView>(R.id.imgbProfile) }
    private val txtUserName: TextView by lazy { itemView.findViewById<TextView>(R.id.txtUserName) }
    private val txtUserMessage: TextView by lazy { itemView.findViewById<TextView>(R.id.txtUserMessage) }
    private val txtDate: TextView by lazy { itemView.findViewById<TextView>(R.id.txtDate) }

    //Item içerisinde onItemClick listelener sayesinde er elemana tıklanmasını sağlar.
    fun bind(chatsEntity: ChatsEntity, onItemClickListener: (chatsEntity: ChatsEntity) -> Unit) {

        imgProfile.setBackgroundResource(chatsEntity.userProfilPhoto)
        txtUserName.text = chatsEntity.userName
        txtUserMessage.text = chatsEntity.userMessage
        txtDate.text = chatsEntity.messageDate

        itemView.setOnClickListener {

            onItemClickListener(chatsEntity)
        }
    }
}