package com.carlos.mvvmguidedevexpert

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import androidx.core.graphics.drawable.toDrawable
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

    private val _url = MutableLiveData<String>()
    var url: LiveData<String>  = _url


    fun onButtonClicked(user:  String, pass: String){
        viewModelScope.launch{
            _progressVisibility.value = true
            _message.value = (withContext(Dispatchers.IO){
                Thread.sleep(2000)
                if (user.isNotEmpty() && pass.isNotEmpty() ) "success" else "Failure"
            })
            _progressVisibility.value = false
            _url.value = "https://static.wikia.nocookie.net/dragonball/images/1/14/Son_Goku_SDBHBM_Artwork.png/revision/latest?cb=20200505114113&path-prefix=es"
        }
    }


}