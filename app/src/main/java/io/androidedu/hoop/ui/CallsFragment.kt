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
import io.androidedu.hoop.util.CallDummyData
import kotlinx.android.synthetic.main.fragment_calls.*

class CallsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(recycCallList) {
            adapter = CallListAdapter(CallDummyData.getDummyCallList()) { callModel ->
                Toast.makeText(activity, "${callModel.userName}", Toast.LENGTH_SHORT).show()
            }
            layoutManager = LinearLayoutManager(activity)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(): CallsFragment = CallsFragment()
    }
}
