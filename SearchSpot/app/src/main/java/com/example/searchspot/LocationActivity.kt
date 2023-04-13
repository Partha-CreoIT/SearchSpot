package com.example.searchspot

import android.content.pm.PackageManager
import android.location.LocationRequest
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.searchspot.databinding.ActivityLocationBinding
import com.google.android.gms.location.FusedLocationProviderClient

class LocationActivity : AppCompatActivity() {
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var binding: ActivityLocationBinding
    lateinit var locationRequest: LocationRequest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.getLoc.setOnClickListener {
            fetchLoc()
        }
    }

    private fun fetchLoc() {
        val task = fusedLocationProviderClient.lastLocation
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                101
            )
            return
        }
        task.addOnSuccessListener {
            if (it != null) {
                Toast.makeText(
                    applicationContext,
                    "${it.latitude}${it.longitude}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    }
}