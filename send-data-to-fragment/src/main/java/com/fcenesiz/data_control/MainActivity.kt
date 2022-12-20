package com.fcenesiz.data_control

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fcenesiz.data_control.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSendToFragment.setOnClickListener {
            sendWithFragment(addFragment())
        }
    }

    private fun addFragment() :FragmentA{
        val fragmentA = FragmentA()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(binding.frame.id, fragmentA, "FRAGMENT_A")
        transaction.commit()
        return fragmentA
    }

    private fun sendWithBundle(fragment : FragmentA) {
        val bundle = Bundle()
        val number1 = binding.editTextN1.text.toString().toInt()
        val number2 = binding.editTextN2.text.toString().toInt()
        bundle.putInt("number_1", number1)
        bundle.putInt("number_2", number2)
        fragment.arguments = bundle
    }

    private fun sendWithFragment(fragment : FragmentA) {

        val number1 = binding.editTextN1.text.toString().toInt()
        val number2 = binding.editTextN2.text.toString().toInt()

        fragment.sendData(number1, number2)
    }


}