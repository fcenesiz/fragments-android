package com.fcenesiz.send_data_fragment_to_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fcenesiz.send_data_fragment_to_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), DataListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragments()
    }

    private fun addFragments(){
        val fragmentA = FragmentA()
        val fragmentB = FragmentB()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(binding.frame1.id, fragmentA, "FRAGMENT_A")
        transaction.add(binding.frame2.id, fragmentB, "FRAGMENT_B")
        transaction.commit()

    }

    override fun onDataSend(n1: Int, n2: Int) {
        val fragmentB = supportFragmentManager.findFragmentByTag("FRAGMENT_B") as FragmentB
        fragmentB.addTwoNumbers(n1, n2)
    }
}