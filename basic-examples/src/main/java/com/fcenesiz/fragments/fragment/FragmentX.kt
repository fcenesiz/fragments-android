package com.fcenesiz.fragments.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fcenesiz.fragments.databinding.FragmentXBinding

class FragmentX: Fragment() {

    lateinit var binding: FragmentXBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentXBinding.inflate(inflater, container, false)
        return binding.root
    }


}