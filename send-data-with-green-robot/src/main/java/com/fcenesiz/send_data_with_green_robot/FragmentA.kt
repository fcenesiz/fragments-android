package com.fcenesiz.send_data_with_green_robot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fcenesiz.send_data_with_green_robot.databinding.FragmentABinding
import com.fcenesiz.send_data_with_green_robot.event.DataEvent
import org.greenrobot.eventbus.EventBus


class FragmentA : Fragment() {

    lateinit var binding: FragmentABinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentABinding.inflate(inflater, container, false)
        binding.buttonSendData.setOnClickListener { sendDataToActivity() }
        return binding.root
    }

    private fun sendDataToActivity() {
        val n1 = binding.editTextN1.text.toString().toInt()
        val n2 = binding.editTextN2.text.toString().toInt()
        val dataEvent = DataEvent(n1, n2)
        EventBus.getDefault().post(dataEvent) // like broadcast
    }
}