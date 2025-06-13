package com.example.videocamerasdisplayapp.ui.snapshots

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.videocamerasdisplayapp.databinding.FragmentSnapshotsPageBinding

class SnapshotsFragment : Fragment() {

    private var _binding: FragmentSnapshotsPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSnapshotsPageBinding.inflate(inflater, container, false)
        val root = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}