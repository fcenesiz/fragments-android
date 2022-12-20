package com.fcenesiz.senddatatoactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fcenesiz.senddatatoactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), DataListener {

    lateinit var binding: ActivityMainBinding
    lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragment()
    }

    fun addFragment(){
        fragmentA = FragmentA()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(binding.frame.id, fragmentA, "FRAGMENT_A")
        transaction.commit()
    }

    override fun onDataSend(number1: Int, number2: Int) {
        binding.textViewResult.text = "$number1 + $number2 = ${number1 + number2}"
    }
}