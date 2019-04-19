package io.androidedu.hoop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.R
import io.androidedu.hoop.model.CallModel

class CallViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(
        R.layout.adapter_item_call_list,
        parent, false
    )
) {

    private val imgProfile: ImageView
    private val txtUserName: TextView
    private val imgPhoneIcon: ImageView
    private val txtDate: TextView

    init {
        imgProfile = itemView.findViewById(R.id.imgbProfile)
        txtUserName = itemView.findViewById(R.id.txtUserName)
        imgPhoneIcon = itemView.findViewById(R.id.imgbPhone)
        txtDate = itemView.findViewById(R.id.txtDate)
    }

    fun bind(callModel: CallModel, onItemClickListener: (callModel: CallModel) -> Unit) {

        imgProfile.setBackgroundResource(callModel.profilePhoto)
        txtUserName.text = callModel.userName
        imgPhoneIcon.setBackgroundResource(callModel.phoneIcon)
        txtDate.text = callModel.date

        itemView.setOnClickListener {

            onItemClickListener(callModel)
        }
    }
}