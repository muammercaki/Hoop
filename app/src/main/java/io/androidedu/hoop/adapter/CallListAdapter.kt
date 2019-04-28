package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.entity.CallEntity


class CallListAdapter(
    var callList: List<CallEntity>,
    val onItemClickListener: (callEntity: CallEntity) -> Unit,
    val onLongClickListener: (callEntity: CallEntity) -> Boolean
) : RecyclerView.Adapter<CallViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder = CallViewHolder(parent)


    override fun getItemCount(): Int = callList.size


    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        holder.bind(callList[position], onItemClickListener, onLongClickListener)
    }

    fun setNewItem(callList: List<CallEntity>) { //dışardan istenen listeyi consturact içerisindeki listeye eşitle

        this.callList = callList
        notifyDataSetChanged()
    }


}