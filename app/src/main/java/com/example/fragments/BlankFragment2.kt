package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragments.databinding.Fragment2Binding


class BlankFragment2 : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFrag2.observe(activity as LifecycleOwner, {
            binding.tvMessage.text = it
        })
        binding.bSendToFrag1.setOnClickListener {
            dataModel.messageForFrag1.value = "Hello From Fragment 2"
        }
        binding.bSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity From Fragment 2"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}