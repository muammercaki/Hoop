package io.androidedu.hoop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.R
import io.androidedu.hoop.model.StatusModel

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

    fun bind(statusModel: StatusModel, onItemClickListener: (statusModel: StatusModel) -> Unit) {

        profilPhoto.setBackgroundResource(statusModel.profilPhoto)
        txtUserName.text = statusModel.myStatus
        txtMyStatus.text = statusModel.statusMessage
        itemView.setOnClickListener {

            onItemClickListener(statusModel)
        }
    }

}