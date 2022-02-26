package com.example.labwork

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val list = MutableLiveData<List<String>>(emptyList<String>())

    fun addStr(str: String) {
        list.value = list.value?.plus(str)
    }
}