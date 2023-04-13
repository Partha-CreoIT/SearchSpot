package com.example.searchspot

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {

    private var onCreateCount = 0
    private var onPauseCount = 0
    private var onResumeCount = 0
    private var onStopCount = 0
    private lateinit var tvOnCreateCount: TextView
    private lateinit var tvOnPauseCount: TextView
    private lateinit var tvOnResumeCount: TextView
    private lateinit var tvOnStopCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tvOnCreateCount = findViewById(R.id.tvOnCreateCount)
        tvOnPauseCount = findViewById(R.id.tvOnPauseCount)
        tvOnResumeCount = findViewById(R.id.tvOnResumeCount)
        tvOnStopCount = findViewById(R.id.tvOnStopCount)
        onCreateCount++
        updateCountText()
    }

    override fun onResume() {
        super.onResume()
        onResumeCount++
        updateCountText()
    }

    override fun onPause() {
        super.onPause()
        onPauseCount++
        updateCountText()
    }

    /*override fun onStop() {
        super.onStop()
        onStopCount++
        updateCountText()
    }*/

    /*override fun onDestroy() {
        super.onDestroy()
        onStopCount++
        updateCountText()
    }*/


    private fun updateCountText() {
        tvOnCreateCount.text = "onCreate Count: $onCreateCount"
        tvOnPauseCount.text = "onPause Count: $onPauseCount"
        tvOnResumeCount.text = "onResume Count: $onResumeCount"
        tvOnStopCount.text = "onStop Count: $onStopCount"
    }

}
