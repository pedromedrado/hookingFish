package com.example.hookingfish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var textshow: TextView
    private lateinit var spinner: Spinner
    private lateinit var button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //textshow = findViewById(R.id.txt_show)
        spinner = findViewById(R.id.spinner)
        button = findViewById(R.id.button)
        val nomes = arrayOf("Pedro", "Ronnyery", "Leonardo")
//
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, nomes)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {


            }

        }

    }
}