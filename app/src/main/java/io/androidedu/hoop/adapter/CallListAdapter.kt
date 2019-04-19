package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.model.CallModel

class CallListAdapter(
    val callList: ArrayList<CallModel>,
    val onItemClickListener: (callModel: CallModel) -> Unit
) : RecyclerView.Adapter<CallViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder = CallViewHolder(parent)


    override fun getItemCount(): Int = callList.size


    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        holder.bind(callList[position], onItemClickListener)
    }


}