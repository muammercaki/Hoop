package io.androidedu.hoop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.R
import io.androidedu.hoop.entity.CallEntity


class CallViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(
        R.layout.adapter_item_call_list,
        parent, false
    )
) {

    private val imgbProfile: ImageView
    private val txtUserName: TextView
    private val imgPhoneIcon: ImageView
    private val txtDate: TextView

    init {
        imgbProfile = itemView.findViewById(R.id.imgbProfile)
        txtUserName = itemView.findViewById(R.id.txtUserName)
        imgPhoneIcon = itemView.findViewById(R.id.imgbPhone)
        txtDate = itemView.findViewById(R.id.txtDate)
    }

    fun bind(
        callEntity: CallEntity,
        onItemClickListener: (callEntity: CallEntity) -> Unit,
        onLongItemClickListener: (callEntity: CallEntity) -> Boolean
    ) {

        imgbProfile.setBackgroundResource(callEntity.callProfilPhoto)
        txtUserName.text = callEntity.callUserName
        imgPhoneIcon.setBackgroundResource(callEntity.callPhoneIcon)
        txtDate.text = callEntity.callMessageDate


        itemView.setOnClickListener {

            onItemClickListener(callEntity)
        }
        itemView.setOnLongClickListener {
            onLongItemClickListener(callEntity)
        }
    }
}