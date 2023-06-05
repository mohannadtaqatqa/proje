package com.example.firstand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.core.widget.addTextChangedListener
import kotlin.math.*

class MainActivity2 : AppCompatActivity() {
    lateinit var convert_button: Button
    lateinit var amountEt:EditText
    lateinit var resultEt: EditText
    lateinit var Todropdown2: AutoCompleteTextView
    lateinit var fromdropdown1: AutoCompleteTextView
    lateinit var toolbar: Toolbar
    val Amricandollar = "American Dollar"
    val GBP = "GBP"
    val AED = "AED"
    val egyptionpound = "Egyption pound"
    val values = mapOf(
        GBP to 0.47,
        egyptionpound to 15.73,
        Amricandollar to 1.0,
        AED to 3.67
    )





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        findbyviewid()
        populateDropDownMenu()

        toolbar.inflateMenu(R.menu.option_menu)
        toolbar.setOnMenuItemClickListener { menuItim ->
            if (menuItim.itemId == R.id.share_action){
                Toast.makeText(this, "Share action clicked", Toast.LENGTH_SHORT).show()
            }
            else if (menuItim.itemId == R.id.setting){
                Toast.makeText(this, "Share setting clicked", Toast.LENGTH_SHORT).show()
            }
            else if (menuItim.itemId == R.id.contact){
                Toast.makeText(this, "Share contact clicked", Toast.LENGTH_SHORT).show()
            }
            true
        }

        amountEt.addTextChangedListener {
            calculateResult()
        }
        fromdropdown1.setOnItemClickListener { adapterView, view, i, l ->
            calculateResult()
        }
        Todropdown2.setOnItemClickListener { adapterView, view, i, l ->
            calculateResult()
        }

    }

    private fun calculateResult(){
        if (amountEt.text.toString().isNotEmpty()){
            val amount = amountEt.text.toString().toDouble()

            val toValue = values[Todropdown2.text.toString()]
            val fromValue = values[fromdropdown1.text.toString()]
            val result = amount.times(toValue!!.div(fromValue!!))
            val formattedResult = String.format("%.3f",result)

            resultEt.setText(result.toString())}

        else{
            amountEt.setError("amount field require")
        }
    }
    private fun populateDropDownMenu(){
        val country = listOf(Amricandollar,GBP,AED,egyptionpound)
        val adapter =  ArrayAdapter(this,R.layout.listcountry,country )
        Todropdown2.setAdapter(adapter)
        fromdropdown1.setAdapter(adapter)
    }
    private fun findbyviewid(){
        convert_button = findViewById(R.id.convert_button)
        amountEt = findViewById(R.id.amount)
        resultEt = findViewById(R.id.resultEd)
        Todropdown2 = findViewById(R.id.dropdown_menu2)
        fromdropdown1 = findViewById(R.id.dropdown_menu1)
        toolbar = findViewById(R.id.toolbar)


    }




}

