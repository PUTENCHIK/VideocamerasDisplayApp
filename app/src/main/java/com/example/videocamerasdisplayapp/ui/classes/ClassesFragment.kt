package com.example.videocamerasdisplayapp.ui.classes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import com.example.videocamerasdisplayapp.R
import com.example.videocamerasdisplayapp.databinding.FragmentClassesPageBinding
import com.example.videocamerasdisplayapp.network.NetworkModule
import com.example.videocamerasdisplayapp.ui.common.DataLoadingFragment
import com.example.videocamerasdisplayapp.ui.common.ErrorFragment
import com.example.videocamerasdisplayapp.ui.common.PageState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okio.IOException
import kotlin.getValue

class ClassesFragment : Fragment() {

    val TAG = "classes_fragment"

    private var _binding: FragmentClassesPageBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ClassesViewModel by activityViewModels()

    lateinit var fm: FragmentManager
    var state = PageState.START

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClassesPageBinding.inflate(inflater, container, false)
        val root = binding.root
        fm = requireActivity().supportFragmentManager

        binding.fab.setOnClickListener { fabOnClick() }
        displayLoading()
        loadClasses()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun loadClasses() {
        CoroutineScope(Dispatchers.IO).launch {
            var classes: List<Class>? = null
            try {
                classes = NetworkModule.classes.get()
                viewModel.setData(classes)
                withContext(Dispatchers.Main) {
                    displayClassesList()
                }
            } catch (e: IOException) {
                Log.e(TAG, "No internet connection: ${e.message}")
                withContext(Dispatchers.Main) {
                    displayError()
                }
            } catch (e: Exception) {
                Log.e(TAG, "Unknown error: ${e.message}")
                withContext(Dispatchers.Main) {
                    displayError()
                }
            }
        }
    }

    fun fabOnClick() {
        if (state != PageState.ADD_CLASS) {
            state = PageState.ADD_CLASS
            updateContentWithState()
        }
    }

    fun displayLoading() {
        if (state != PageState.LOADING) {
            state = PageState.LOADING
            updateContentWithState()
        }
    }

    fun displayError() {
        if (state != PageState.ERROR) {
            state = PageState.ERROR
            updateContentWithState()
        }
    }

    fun displayClassesList() {
        if (state != PageState.CLASSES_LIST) {
            state = PageState.CLASSES_LIST
            updateContentWithState()
        }
    }

    fun updateContentWithState() {
        var fragment: Fragment? = null
        fragment = when (state) {
            PageState.LOADING -> {
                binding.fab.visibility = View.INVISIBLE
                DataLoadingFragment()
            }
            PageState.ERROR -> {
                binding.fab.visibility = View.INVISIBLE
                ErrorFragment()
            }
            PageState.CLASSES_LIST -> {
                binding.fab.visibility = View.VISIBLE
                ClassesListFragment()
            }
            PageState.ADD_CLASS -> {
                binding.fab.visibility = View.INVISIBLE
                ClassPageFragment()
            }
            else -> null
        }
        fragment?.let {
            val ft = fm.beginTransaction()
            ft.replace(R.id.frame_container, it).commit()
        }
    }
}