package io.androidedu.hoop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.R
import io.androidedu.hoop.entity.StatusEntity

class StatusViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_status_list, parent, false)
) {

    private val profilPhoto: ImageView
    private val txtUserName: TextView
    private val txtMyStatus: TextView

    init {
        profilPhoto = itemView.findViewById(R.id.profilPhotoStatus)
        txtUserName = itemView.findViewById(R.id.txtUserName)
        txtMyStatus = itemView.findViewById(R.id.txtMyStatus)
    }

    fun bind(statusEntity: StatusEntity, onItemClickListener: (statusEntity: StatusEntity) -> Unit) {

        profilPhoto.setBackgroundResource(statusEntity.statusProfilPhoto)
        txtUserName.text = statusEntity.statusUserName
        txtMyStatus.text = statusEntity.statusUserMessage
        itemView.setOnClickListener {

            onItemClickListener(statusEntity)
        }
    }

}