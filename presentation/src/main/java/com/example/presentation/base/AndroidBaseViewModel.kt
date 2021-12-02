package com.example.presentation.base

import android.app.Application
import androidx.annotation.StringRes
import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.presentation.util.Resource


open class AndroidBaseViewModel(val app: Application) : AndroidViewModel(app), Observable {
    private val mCallBacks: PropertyChangeRegistry = PropertyChangeRegistry()
    val mutableLiveData = MutableLiveData<Any?>()
    var isLoading = ObservableBoolean()
    // for network
    val resultLiveData = MutableLiveData<Resource<Any?>?>()

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallBacks.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        mCallBacks.add(callback)
    }

    fun notifyChange() {
        mCallBacks.notifyChange(this, 0)
    }

    fun notifyChange(propertyId: Int) {
        mCallBacks.notifyChange(this, propertyId)
    }

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

    fun getString(@StringRes stringRes: Int): String {
        return app.getString(stringRes)
    }

}