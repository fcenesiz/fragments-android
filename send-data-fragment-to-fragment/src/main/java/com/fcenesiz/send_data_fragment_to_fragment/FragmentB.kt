package com.fcenesiz.send_data_fragment_to_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fcenesiz.send_data_fragment_to_fragment.databinding.FragmentABinding
import com.fcenesiz.send_data_fragment_to_fragment.databinding.FragmentBBinding

class FragmentB : Fragment() {

    lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun addTwoNumbers(n1:Int, n2:Int){
        binding.textViewResult.text = "$n1 + $n2 = ${n1 + n2}"
    }
}