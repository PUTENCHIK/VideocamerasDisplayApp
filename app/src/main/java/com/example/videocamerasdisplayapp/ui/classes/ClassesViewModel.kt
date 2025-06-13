package com.example.videocamerasdisplayapp.ui.classes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClassesViewModel : ViewModel() {

    private val _data = MutableLiveData<List<Class>>(emptyList())
    val data: LiveData<List<Class>> = _data

    fun getData(): List<Class> {
        return data.value
    }

    fun setData(new: List<Class>) {
        _data.postValue(new)
    }
}