package com.example.firstand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calulater = findViewById<Button>(R.id.btn1)
        val currency = findViewById<Button>(R.id.btn2)


        calulater.setOnClickListener {
            startActivity(Intent(this , CalculaterActivity::class.java))
        }
        currency.setOnClickListener {
            startActivity(Intent(this , MainActivity2::class.java))
        }
    }
}