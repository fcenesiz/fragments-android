package com.fcenesiz.send_data_with_green_robot

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fcenesiz.send_data_with_green_robot.databinding.FragmentBBinding
import com.fcenesiz.send_data_with_green_robot.event.ResultEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


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

    @Subscribe
    fun triggerOnResultReceived(resultEvent: ResultEvent){
        binding.textViewResult.text = "RESULT: ${resultEvent.result}"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        EventBus.getDefault().register(this)
    }

    override fun onDetach() {
        super.onDetach()
        EventBus.getDefault().unregister(this)
    }
}