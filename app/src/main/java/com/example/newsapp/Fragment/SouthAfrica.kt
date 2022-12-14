package com.example.newsapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.Adapter.SouthAfricaAdapter
import com.example.newsapp.ArticlesItem
import com.example.newsapp.ModelData
import com.example.newsapp.R
import com.example.newsapp.Retrofit.ApiClient
import com.example.newsapp.Retrofit.ApiInterface
import com.example.newsapp.databinding.FragmentIndiaBinding
import com.example.newsapp.databinding.FragmentSouthAfricaBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SouthAfrica : Fragment() {

    lateinit var binding: FragmentSouthAfricaBinding
    var list= arrayListOf<ArticlesItem>()
    var datalist= arrayListOf<ModelData>()
    lateinit var southAfricaAdapter: SouthAfricaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentSouthAfricaBinding.bind(inflater.inflate(R.layout.fragment_south_africa,container,false))
        apiCalling("sa","business","693546ac97cd465d9b9055f0db7ae875")
        return binding.root
    }

    fun apiCalling(country:String,catagory:String,apiKey :String) {
        var apiInterface = ApiClient.getRetrofit().create(ApiInterface::class.java)

        apiInterface.getData(country,catagory,apiKey).enqueue(object : Callback<ModelData> {

            override fun onResponse(call: Call<ModelData>, response: Response<ModelData>) {

                var datamodel = response.body()

                list = datamodel?.articles as ArrayList<ArticlesItem>

                rvSetup()
            }
            override fun onFailure(call: Call<ModelData>, t: Throwable) {}
        })

    }


    fun rvSetup() {
        southAfricaAdapter =SouthAfricaAdapter(activity,list)
        var lm= LinearLayoutManager(activity)
        binding.rcy.layoutManager =lm
        binding.rcy.adapter=southAfricaAdapter
    }
}