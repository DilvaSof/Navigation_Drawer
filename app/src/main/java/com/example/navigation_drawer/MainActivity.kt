package com.example.navigation_drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat

class MainActivity : AppCompatActivity() {

    private lateinit var toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toogle= ActionBarDrawerToggle(this, drawer_layout, R.string.open_drawer, R.string.close_drawer, )
        drawer_layout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.FragmentContainerView, HomeFragment())
                        commit()
                    }
                }

                R.id.nav_camera -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.FragmentContainerView, CameraFragment())
                        commit()
                    }
                }

                R.id.nav_gallery -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.FragmentContainerView, GalleryFragment())
                        commit()
                    }
                }

                R.id.nav_messages -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.FragmentContainerView, MessagesFragment())
                        commit()
                    }
                }
            }
            drawer_layout.closeDrawer(GravityCompat.START)

            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}