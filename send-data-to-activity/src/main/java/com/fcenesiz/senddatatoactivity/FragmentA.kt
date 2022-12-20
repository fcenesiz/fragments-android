package com.fcenesiz.senddatatoactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fcenesiz.senddatatoactivity.databinding.FragmentABinding

class FragmentA : Fragment(){

    lateinit var binding : FragmentABinding
    lateinit var dataListener: DataListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentABinding.inflate(inflater, container, false)
        binding.buttonSendToActivity.setOnClickListener { sendData() }
        return binding.root
    }

    private fun sendData(){
        setOnDatListener()
        val number1 = binding.editTextN1.text.toString().toInt()
        val number2 = binding.editTextN2.text.toString().toInt()
        dataListener.onDataSend(number1, number2)
    }

    private fun setOnDatListener(){
        this.dataListener = activity as MainActivity
    }

}