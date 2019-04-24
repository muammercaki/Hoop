package io.androidedu.hoop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.StatusListAdapter
import io.androidedu.hoop.db.StatusDB
import io.androidedu.hoop.entity.StatusEntity
import kotlinx.android.synthetic.main.fragment_status.*
import kotlin.concurrent.thread

class StatusFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val statusDB = StatusDB.getInstance(activity!!)
        val statusDao = statusDB?.getStatusDao()

        val statusEntity = StatusEntity(
            statusProfilPhoto = R.drawable.ic_man,
            statusUserName = "Muammer Çakı",
            statusUserMessage = "lksndvjnsdjkn"
        )

        thread(start = true) {
            statusDao?.addNewItem(statusEntity)
        }

        var allStatusList: List<StatusEntity>?

        thread(start = true) {
            allStatusList = statusDao?.getAllList()

            // Log.e("MainActivity",allChatsList!![1].userName)

            recyStatusList.adapter = StatusListAdapter(allStatusList!!) {
                var newStatusList: List<StatusEntity>? = null

                thread(start = true) {
                    newStatusList = statusDao?.getAllList()!!
                }
            }
            recyStatusList.layoutManager = LinearLayoutManager(activity!!)
        }
        /*
        with(recyStatusList) {
            adapter = StatusListAdapter(StatusDummyData.getStatusDummyData()) { statusModel ->
                Toast.makeText(activity, "${statusModel.myStatus}", Toast.LENGTH_SHORT).show()

            }
            layoutManager = LinearLayoutManager(activity)
        }*/
    }

    companion object {
        @JvmStatic
        fun newInstance() = StatusFragment()
    }
}
