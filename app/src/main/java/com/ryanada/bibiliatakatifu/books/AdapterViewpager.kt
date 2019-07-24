package com.ryanada.bibiliatakatifu.books

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


// Returns a fragment corresponding to one of the tabs/pages
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    // Called to instantiate the fragment for the given page.
    override fun getItem(position: Int): Fragment {
        // Return a TestamentFragment
        return TestamentFragment.newInstance(position)
    }

    // Tab names
    override fun getPageTitle(position: Int): CharSequence? {
        val tabs = arrayOf(
            "Old Testament",
            "New Testament"
        )
        return tabs[position]
    }

    // Number of pages
    override fun getCount(): Int {
        return 2
    }
}