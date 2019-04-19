package io.androidedu.hoop.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import io.androidedu.hoop.R
import io.androidedu.hoop.adapter.HoopViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val chatsFragment by lazy { ChatsFragment.newInstance() }
    private val statusFragment by lazy { StatusFragment.newInstance() }
    private val cameraFragment by lazy { CameraFragment.newInstance() }
    private val callsFragment by lazy { CallsFragment.newInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val fragmentList = ArrayList<Fragment>()
        fragmentList.add(cameraFragment)
        fragmentList.add(chatsFragment)
        fragmentList.add(statusFragment)
        fragmentList.add(callsFragment)

        val fragmentTitleList = ArrayList<String>()
        fragmentTitleList.add("Camera")
        fragmentTitleList.add("Chats")
        fragmentTitleList.add("Status")
        fragmentTitleList.add("Calls")


        vpHoopContainer.adapter = HoopViewPagerAdapter(fragmentTitleList, fragmentList, supportFragmentManager)
        vpHoopTabLayContainer.setupWithViewPager(vpHoopContainer)
        vpHoopContainer.currentItem = 1
        //addFragment(R.id.frmContainer, chatsFragment)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.newGroup -> {

                return true
            }
            R.id.newGroupMessage -> {

                return true
            }
            R.id.hoopWeb -> {

                return true
            }
            R.id.starMessage -> {

                return true
            }
            R.id.settings -> {

                return true
            }
            R.id.search -> {
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }

    }

}


/*
    override fun onClick(v: View) {

        when (v.id) {

            R.id.txtCalls -> {

                replaceFragment(R.id.frmContainer, callsFragment)
            }

            R.id.txtChats -> {

                replaceFragment(R.id.frmContainer, chatsFragment)
            }

            R.id.txtStatus -> {

                replaceFragment(R.id.frmContainer, statusFragment)
            }

            R.id.imgbCamera -> {

                replaceFragment(R.id.frmContainer, cameraFragment)
            }
        }
    }


}

inline fun FragmentManager.inTransaction(function: FragmentTransaction.() -> FragmentTransaction) {

    beginTransaction().function().commit()
}

fun AppCompatActivity.addFragment(containerId: Int, fragment: Fragment) {

    supportFragmentManager.inTransaction {

        add(containerId, fragment)
    }
}


fun AppCompatActivity.replaceFragment(containerId: Int, fragment: Fragment) {

    supportFragmentManager.inTransaction {

        replace(containerId, fragment)
    }*/
