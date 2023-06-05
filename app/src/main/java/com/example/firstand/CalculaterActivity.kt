package com.example.firstand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.*

class CalculaterActivity : AppCompatActivity() {
    lateinit var one : Button
    lateinit var two : Button
    lateinit var three : Button
    lateinit var four : Button
    lateinit var five : Button
    lateinit var six : Button
    lateinit var sev : Button
    lateinit var eig : Button
    lateinit var nin : Button
    lateinit var zero : Button
    lateinit var div : Button
    lateinit var mul : Button
    lateinit var plus : Button
    lateinit var sub : Button
    lateinit var equal : Button
    lateinit var exit : Button
    lateinit var AC : Button
    lateinit var delete : Button
    lateinit var dot : Button
    lateinit var prisntage : Button
    lateinit var disply: TextView
    private  var input :String=""
    private  var oldInput :String=""
    private  var operator :Char=' '
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculater)
        findByViewId()

        one.setOnClickListener { appendInput("1") }
        two.setOnClickListener { appendInput("2") }
        three.setOnClickListener { appendInput("3") }
        four.setOnClickListener { appendInput("4") }
        five.setOnClickListener { appendInput("5") }
        six.setOnClickListener { appendInput("6") }
        sev.setOnClickListener { appendInput("7") }
        eig.setOnClickListener { appendInput("8") }
        nin.setOnClickListener { appendInput("9") }
        dot.setOnClickListener { appendInput(".") }

        plus.setOnClickListener { performOperation('+') }
        sub.setOnClickListener { performOperation('-') }
        mul.setOnClickListener { performOperation('*') }
        div.setOnClickListener { performOperation('/') }
        equal.setOnClickListener { performOperation('=') }
        AC.setOnClickListener { clearInput() }
        delete.setOnClickListener { deleteInput() }



    }

    private fun findByViewId(){
        one  = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three  = findViewById(R.id.three)
        four  = findViewById(R.id.four)
        five  = findViewById(R.id.five)
        six  = findViewById(R.id.six)
        sev  = findViewById(R.id.seven)
        eig  = findViewById(R.id.eight)
        nin  = findViewById(R.id.nine)
        zero  = findViewById(R.id.zero)
        div  = findViewById(R.id.div)
        mul  = findViewById(R.id.mul)
        plus  = findViewById(R.id.plus)
        sub  = findViewById(R.id.sub)
        prisntage  = findViewById(R.id.presintage)
        equal =findViewById(R.id.equal)
        exit  = findViewById(R.id.Exit)
        AC  = findViewById(R.id.AC)
        delete  = findViewById(R.id.delete)
        dot  = findViewById(R.id.point)
        disply = findViewById(R.id.inputTxt)


    }

    private fun appendInput(value : String){
        if(value == "." && input.contains(".")){
            return

        }else{
            input+=value;
            updateDisply()
        }
    }
    private fun updateDisply(){
        disply.text = input
    }
    private fun deleteInput(){
        if(input.isNotEmpty())
            input = input.substring(0,input.length-1)
        updateDisply()
    }

    private fun clearInput(){
        input=""
        oldInput=""
        operator=' '
        updateDisply()
    }

    private fun performOperation(newOperator : Char){
        if (operator != ' '){
            val newValue = input.toFloat()
            when (operator) {
                '+' -> input = (oldInput.toFloat() + newValue).toString()
                '-' -> input = (oldInput.toFloat() - newValue).toString()
                '*' -> input = (oldInput.toFloat() * newValue).toString()
                '/' -> input = (oldInput.toFloat() / newValue).toString()
            }
            oldInput = ""
            operator = ' '
            updateDisply()
        } else {
            oldInput = input
            input = ""
            operator = newOperator

        }
    }

}