package com.carlos.mvvmguidedevexpert

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.android.volley.Response
import com.carlos.mvvmguidedevexpert.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext


class MainActivity : AppCompatActivity() {

    private lateinit var viewModelMain: MainViewModel

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModelMain = ViewModelProvider(this).get()
//
//        viewModel.progressVisibiliy.observe(this, Observer {
////            when(it){
////                 true -> binding.progress.visibility = View.VISIBLE
////                 false -> binding.progress.visibility = View.GONE
////            }
//            binding.progress.visibility = it
//        })
//        viewModel.message.observe(this, Observer {
//            binding.message.text = it
//        })
        binding.viewModel = viewModelMain
        binding.lifecycleOwner = this

//        with(binding){
//            button.setOnClickListener{
//                viewModelMain.onButtonClicked(user.text.toString(),pass.text.toString());
//            }
//        }
    }

    fun setProgressVisible(boolean: Boolean) {
//        when(boolean){
//            true -> binding.progress.visibility = View.VISIBLE
//            false -> binding.progress.visibility = View.GONE
//        }

    }

    fun setMessage(message: String) {
        binding.message.text = message
    }

}