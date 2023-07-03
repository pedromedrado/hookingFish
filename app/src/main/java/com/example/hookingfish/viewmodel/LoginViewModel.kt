package com.example.hookingfish.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hookingfish.model.Model
import com.example.hookingfish.model.SucessFailure
import com.example.hookingfish.repository.HookingRepository

class LoginViewModel (application: Application)  : AndroidViewModel(application){

    private val repository = HookingRepository.getInstance(application)

    private  val model = MutableLiveData<Model>()
    val hooking : LiveData<Model> = model

    fun save (data: Model){
        val sucessoFailure = SucessFailure(true,"")

        if(data.id == 0){
            sucessoFailure.sucess = repository.insert(data)
        }else{
            Toast.makeText(getApplication(), "Nao foi foi criado ", Toast.LENGTH_SHORT).show()
        }

    }



}