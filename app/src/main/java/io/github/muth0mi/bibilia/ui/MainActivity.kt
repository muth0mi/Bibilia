package io.github.muth0mi.bibilia.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}
/*
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityBooksBinding
    lateinit var booksAdapter: AdapterRecyclerview

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
            var testament = Testament()
            testament.testament = if (binding.include.viewPager.currentItem == 0) "OLD"
            else "NEW"

            var books = SQliteTransactions(this@MainActivity).getBooks(testament)
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
 */