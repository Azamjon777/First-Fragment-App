package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragments.databinding.Fragment1Binding
import com.example.fragments.databinding.Fragment2Binding

class BlankFragment : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = Fragment1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFrag1.observe(activity as LifecycleOwner, {
            binding.tvMessage.text = it
        })
        binding.bSendToFrag2.setOnClickListener {
            dataModel.messageForFrag2.value = "Hello From Fragment 1"
        }
        binding.bSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity From Fragment 1"
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}