package com.example.newsapp.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.newsapp.Fragment.*

class TabAdapter(fm :FragmentManager) :FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return 5
    }

    override fun getItem(position: Int): Fragment {

        val f1= when(position)
        {
            0->India()
            1->Us()
            2->China()
            3->Korea()
            4->SouthAfrica()
            else->India()
        }
        return f1
    }

}