package com.example.abdelrahmantealab_mapd711_assignment3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun citySelected(view: View){
        val button = view as Button
        val city = button.text.toString()
        println(city)
        val intent = Intent(this, MapsActivity::class.java).apply {
            putExtra("city",city)
        }
        startActivity(intent)
    }

}