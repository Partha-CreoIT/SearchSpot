package com.example.searchspot

import MainAdapter
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.searchspot.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private val viewModel by inject<CityViewModel>()
    private val retrofitService = ApiInterface.getInstance()
    private val adapter = MainAdapter()
    private val cityViewModel: CityViewModel by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Select The City"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)




/*        val dividerDrawable: Drawable? = ContextCompat.getDrawable(this, R.drawable.divider)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDrawable(dividerDrawable!!)
        recyclerView.addItemDecoration(dividerItemDecoration)*/


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter

        recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        cityViewModel.getAllCity()
        viewModel.getAllCity()

        viewModel.cityList.observe(this) {
            Log.d(TAG, "onCreate: $it")
            adapter.setCityList(it)
            adapter.also { recyclerView.adapter = it }
        }
        viewModel.errorMessage.observe(this, Observer {})

    }

}

