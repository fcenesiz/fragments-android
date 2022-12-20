package com.fcenesiz.send_data_fragment_to_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fcenesiz.send_data_fragment_to_fragment.databinding.FragmentABinding

class FragmentA : Fragment() {

    lateinit var binding: FragmentABinding
    lateinit var dataListener: DataListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataListener = activity as MainActivity
        binding = FragmentABinding.inflate(inflater, container, false)
        binding.buttonSendData.setOnClickListener {
            dataListener.onDataSend(
                binding.editTextN1.text.toString().toInt(),
                binding.editTextN2.text.toString().toInt()
            )
        }
        return binding.root
    }
}