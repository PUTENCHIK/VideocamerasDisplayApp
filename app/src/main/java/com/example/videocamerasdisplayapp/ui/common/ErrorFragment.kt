package com.example.videocamerasdisplayapp.ui.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.videocamerasdisplayapp.databinding.FragmentErrorBinding

class ErrorFragment : Fragment() {

    private var _binding: FragmentErrorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentErrorBinding.inflate(inflater, container, false)
        val root = binding.root

        return root
    }
}