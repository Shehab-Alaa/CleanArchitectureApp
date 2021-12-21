package com.example.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.usecase.Resource

open class BaseViewModel: ViewModel() {

    val mutableLiveData = MutableLiveData<Any?>()
    // for network
    val resultLiveData = MutableLiveData<Resource<Any?>?>()

    fun setValue(o: Any?) {
        mutableLiveData.value = o
    }

    fun postValue(o: Any?) {
        mutableLiveData.postValue(o)
    }

    fun setResult(o: Resource<Any?>?) {
        resultLiveData.value = o
    }

    fun postResult(o: Resource<Any?>?) {
        resultLiveData.postValue(o)
    }

}