package com.carlos.mvvmguidedevexpert

import android.view.View
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(): ViewModel() {

    private val _progressVisibility = MutableLiveData<Boolean>()
    val progressVisibility: LiveData<Boolean> = _progressVisibility

    private val _message = MutableLiveData<String>()
    var message: LiveData<String>  = _message

    fun onButtonClicked(user:  String, pass: String){
        viewModelScope.launch{
            _progressVisibility.value = true
            _message.value = (withContext(Dispatchers.IO){
                Thread.sleep(2000)
                if (user.isNotEmpty() && pass.isNotEmpty() ) "success" else "Failure"
            })
            _progressVisibility.value = false
        }
    }


}