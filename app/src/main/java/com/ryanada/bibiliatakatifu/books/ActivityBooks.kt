package com.ryanada.bibiliatakatifu.books

import android.os.Bundle
import android.view.MenuItem
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.ryanada.bibiliatakatifu.R
import com.ryanada.bibiliatakatifu.databinding.ActivityBooksBinding
import com.ryanada.bibiliatakatifu.objects.Book
import kotlinx.android.synthetic.main.activity_books_appbar.view.*

class ActivityBooks : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityBooksBinding
    lateinit var booksAdapter: AdapterRecyclerview
    var books = ArrayList<Book>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bind layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_books)

        val toolbar: MaterialToolbar = binding.include.toolBar
        setSupportActionBar(toolbar)

        booksAdapter = AdapterRecyclerview(this)

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

        // Search view
        val searchView = binding.include.svSearch

        //change search icon color
        val searchIcon = searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_button)
        searchIcon.setColorFilter(resources.getColor(R.color.colorSurface))

        //change search icon color
        val searchAutoComplete = searchView.findViewById<AutoCompleteTextView>(androidx.appcompat.R.id.search_src_text)
        searchAutoComplete.setHintTextColor(resources.getColor(R.color.colorSurfaceLight))
        searchAutoComplete.setTextColor(resources.getColor(R.color.colorSurface))


    }


    val bookSearcher = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return false
        }

        override fun onQueryTextChange(newText: String): Boolean {
            // Search query
            val results = ArrayList<Book>()

            for (book in books) {
                if (book.book!!.toLowerCase().contains(newText.toLowerCase())) {
                    results.add(book)
                }
                booksAdapter.setBooks(results)


//                        if (results.isEmpty()) binding.tvNoResults.visibility = View.VISIBLE
//                        else binding.tvNoResults.visibility = View.GONE
            }

            return false
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Side Navigation View handler
        when (item.itemId) {
            R.id.nav_search -> {
            }
            R.id.nav_favourites -> {
            }
            else -> {
            }
        }

        // Close nav drawer
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}