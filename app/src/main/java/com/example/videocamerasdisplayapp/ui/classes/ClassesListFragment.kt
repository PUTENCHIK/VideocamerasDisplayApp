package com.example.videocamerasdisplayapp.ui.classes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.videocamerasdisplayapp.databinding.FragmentClassesListBinding

class ClassesListFragment : Fragment() {

    val TAG = "classes_list_fragment"

    private var _binding: FragmentClassesListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ClassesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClassesListBinding.inflate(inflater, container, false)
        val root = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rv = binding.classesRecycler
        rv.layoutManager = LinearLayoutManager(context)

        val adapter = ClassesAdapter(requireContext(), emptyList())
        rv.adapter = adapter

        viewModel.data.observe(viewLifecycleOwner, Observer { list ->
            Log.d(TAG, "Data updated: $list")
            adapter.updateData(list)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}