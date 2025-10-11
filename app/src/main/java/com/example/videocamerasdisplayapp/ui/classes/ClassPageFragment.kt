package com.example.videocamerasdisplayapp.ui.classes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.videocamerasdisplayapp.databinding.FragmentClassPageBinding

class ClassPageFragment : Fragment() {

    private var _binding: FragmentClassPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClassPageBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.colorPicker.setOnClickListener { onColorPickerClicked() }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onColorPickerClicked() {
        
    }
}