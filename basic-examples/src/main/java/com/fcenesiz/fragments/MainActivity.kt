package com.fcenesiz.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fcenesiz.fragments.databinding.ActivityMainBinding
import com.fcenesiz.fragments.fragment.FragmentX

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        example01AddNewFragment()
    }

    private fun example01AddNewFragment(){
        val fragmentX = FragmentX()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(binding.layoutExample01.id, fragmentX, "FRAGMENT_X")
        transaction.commit()

    }

}