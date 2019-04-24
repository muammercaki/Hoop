package io.androidedu.hoop.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.androidedu.hoop.entity.StatusEntity

class StatusListAdapter(
    val statusList: List<StatusEntity>,
    val onItemClickListener: (statusEntity: StatusEntity) -> Unit
) : RecyclerView.Adapter<StatusViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder = StatusViewHolder(parent)

    override fun getItemCount(): Int = statusList.size
    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) {
        holder.bind(statusList[position], onItemClickListener)
    }
}