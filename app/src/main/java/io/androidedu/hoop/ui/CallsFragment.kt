package io.androidedu.hoop.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.CallListAdapter
import io.androidedu.hoop.db.AppDB

import io.androidedu.hoop.entity.CallEntity

import kotlinx.android.synthetic.main.fragment_calls.*
import kotlin.concurrent.thread


class CallsFragment : Fragment() {

    var allCallList: ArrayList<CallEntity> = arrayListOf()
    lateinit var adapter: CallListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val callDB = AppDB.getInstance(activity!!)
        val callDao = callDB?.getCallDao()

        val callEntity = CallEntity(
            callProfilPhoto = R.drawable.ic_man,
            callUserName = "Muammer Çakı",
            callMessageDate = "now",
            callPhoneIcon = R.drawable.ic_phone_green
        )

        thread(start = true) {
            callDao?.addNewItem(callEntity)
        }
        recycCallList.layoutManager = LinearLayoutManager(activity!!)

        adapter = CallListAdapter(
            allCallList,
            { _item ->
                recyclerViewItemClick(_item)
            },
            { _item ->
                recyclerViewItemLongClick(_item)
            })


        recycCallList.adapter = adapter


        allCallList.clear()
        thread(start = true) {
            var temp = callDao?.getAllList()

            temp?.forEach { _item ->
                allCallList.add(_item)
            }
            activity!!.runOnUiThread({
                adapter.notifyDataSetChanged()
            })


            // Log.e("MainActivity",allChatsList!![1].userName)
        }
        /*
        with(recycCallList) {
            adapter = CallListAdapter(CallDummyData.getDummyCallList()) { callModel ->
                Toast.makeText(activity, "${callModel.userName}", Toast.LENGTH_SHORT).show()
            }
            layoutManager = LinearLayoutManager(activity)
        }*/

    }

    fun recyclerViewItemClick(item: CallEntity) {
        Toast.makeText(activity!!, "tek tıklama", Toast.LENGTH_SHORT).show()
    }

    fun recyclerViewItemLongClick(item: CallEntity): Boolean {
        Toast.makeText(activity!!, "uzun tıklama", Toast.LENGTH_SHORT).show()
        return true
    }

    companion object {

        @JvmStatic
        fun newInstance(): CallsFragment = CallsFragment()
    }
}
