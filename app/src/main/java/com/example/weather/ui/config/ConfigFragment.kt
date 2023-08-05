package com.example.weather.ui.config

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.weather.R
import com.example.weather.databinding.FragmentConfigBinding
import kotlinx.coroutines.NonDisposableHandle.parent

class ConfigFragment : Fragment() {

    private lateinit var binding: FragmentConfigBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfigBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSaveConfig.setOnClickListener{
            findNavController().navigate(R.id.action_configFragment_to_homeFragment)
        }
    }
}