package com.example.navigation_drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mDrawerLayout =findViewById<DrawerLayout>(R.id.drawer_layout)
        val mNavView = findViewById<NavigationView>(R.id.nav_view)
        toogle= ActionBarDrawerToggle(this, mDrawerLayout , R.string.open_drawer, R.string.close_drawer )
        mDrawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mNavView.setNavigationItemSelectedListener {
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
            mDrawerLayout.closeDrawer(GravityCompat.START)

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

//Verificando cambios