package com.ryanada.bibiliatakatifu.books

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.ryanada.bibiliatakatifu.R
import com.ryanada.bibiliatakatifu.databinding.ActivityBooksBinding
import kotlinx.android.synthetic.main.activity_books_appbar.view.*

class ActivityBooks : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityBooksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bind layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_books)

        // Set Page Title
        binding.title = "Books"

        val toolbar: Toolbar = binding.include.toolBar
        setSupportActionBar(toolbar)

        // Tab layout
        val tabLayout: TabLayout = binding.include.tabLayout
        val viewPager: ViewPager = binding.include.viewPager

        val viewPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)


        val drawerLayout: DrawerLayout = binding.drawerLayout

        // Setup Navigation Drawer toggle
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Setup navigation navigation views
        val navView: NavigationView = binding.navView
        navView.setNavigationItemSelectedListener(this)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Side Navigation View handler
        when (item.itemId) {
            R.id.nav_home -> {
            }
            R.id.nav_gallery -> {
            }
            else -> {
            }
        }

        // Close nav drawer
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to action bar
        menuInflater.inflate(R.menu.activity_books_menu, menu)
        return true
    }
}