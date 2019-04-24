package io.androidedu.hoop.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.CallListAdapter
import io.androidedu.hoop.db.CallDB

import io.androidedu.hoop.entity.CallEntity

import kotlinx.android.synthetic.main.fragment_calls.*
import kotlin.concurrent.thread


class CallsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val callDB = CallDB.getInstance(activity!!)
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

        var allCallList: List<CallEntity>?

        thread(start = true) {
            allCallList = callDao?.getAllList()

            // Log.e("MainActivity",allChatsList!![1].userName)

            recycCallList.adapter = CallListAdapter(allCallList!!) {
                var newCallList: List<CallEntity>? = null

                thread(start = true) {
                    newCallList = callDao?.getAllList()!!
                }
            }
            recycCallList.layoutManager = LinearLayoutManager(activity!!)
        }
        /*
        with(recycCallList) {
            adapter = CallListAdapter(CallDummyData.getDummyCallList()) { callModel ->
                Toast.makeText(activity, "${callModel.userName}", Toast.LENGTH_SHORT).show()
            }
            layoutManager = LinearLayoutManager(activity)
        }*/

    }

    companion object {

        @JvmStatic
        fun newInstance(): CallsFragment = CallsFragment()
    }
}
