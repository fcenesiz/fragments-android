package com.fcenesiz.data_control

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fcenesiz.data_control.databinding.FragmentABinding

class FragmentA : Fragment() {

    lateinit var binding : FragmentABinding

    var number1 = 0
    var number2 = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentABinding.inflate(inflater, container, false)

        arguments?.let { // with Bundle
            val number1 = it.getInt("number_1", 0)
            val number2 = it.getInt("number_2", 0)

            binding.buttonCalculate.setOnClickListener {
                val result = number1 + number2
                binding.textViewResult.text = "$number1 + $number2 = $result"
            }
        } ?: run { // with setData
            binding.buttonCalculate.setOnClickListener {
                val result = number1 + number2
                binding.textViewResult.text = "$number1 + $number2 = $result"
            }
        }


        return binding.root
    }

    fun sendData(number1 : Int, number2: Int){
        this.number1 = number1
        this.number2 = number2
    }

}