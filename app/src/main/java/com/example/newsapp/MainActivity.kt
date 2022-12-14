package com.example.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.Adapter.TabAdapter
import com.example.newsapp.Retrofit.ApiClient.Companion.getRetrofit
import com.example.newsapp.Retrofit.ApiInterface
import com.example.newsapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    var datalist = arrayListOf<ArticlesItem>()
    lateinit var bind:ActivityMainBinding
    lateinit var tabAdapter: TabAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        fragment()


    }


    fun fragment()
    {
                bind.tabbar.addTab(bind.tabbar.newTab().setText("India"))
                bind.tabbar.addTab(bind.tabbar.newTab().setText("Us"))
                bind.tabbar.addTab(bind.tabbar.newTab().setText("China"))
                bind.tabbar.addTab(bind.tabbar.newTab().setText("Korea"))
                bind.tabbar.addTab(bind.tabbar.newTab().setText("Southafrica"))

                tabAdapter = TabAdapter(supportFragmentManager)
                bind.viewpager.adapter=tabAdapter
                bind.viewpager.setOnPageChangeListener(
                TabLayout.TabLayoutOnPageChangeListener(bind.tabbar))

                bind.tabbar.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                    override fun onTabSelected(tab: TabLayout.Tab?) {
                        bind.viewpager.currentItem=tab!!.position
                    }
                    override fun onTabUnselected(tab: TabLayout.Tab?) {}
                    override fun onTabReselected(tab: TabLayout.Tab?) {}
                })

    }


}
