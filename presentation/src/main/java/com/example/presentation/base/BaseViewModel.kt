package com.example.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {

    val mutableLiveData = MutableLiveData<Any?>()

    fun setValue(o: Any?) {
        mutableLiveData.value = o
    }

    fun postValue(o: Any?) {
        mutableLiveData.postValue(o)
    }

}