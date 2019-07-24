package com.ryanada.bibiliatakatifu.books

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ryanada.bibiliatakatifu.R


// Returns a fragment corresponding to one of the tabs/pages
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    // Called to instantiate the fragment for the given page.
    override fun getItem(position: Int): Fragment {
        // Return a FragmentTestament
        return FragmentTestament.newInstance(position)
    }

    // Tab names
    override fun getPageTitle(position: Int): CharSequence? {
        val tabs = arrayOf(
            context.getString(R.string.oldTestament),
            context.getString(R.string.newTestament)
        )
        return tabs[position]
    }

    // Number of pages
    override fun getCount(): Int {
        return 2
    }
}