package com.example.hookingfish.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hookingfish.model.Model
import com.example.hookingfish.model.SucessFailure
import com.example.hookingfish.repository.HookingRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = HookingRepository.getInstance(application.applicationContext)

    private val hookingModel = MutableLiveData<List<Model>>()
    val hooking: LiveData<List<Model>> = hookingModel

    private val _savehooking = MutableLiveData<SucessFailure>()
    val saveHooking: LiveData<SucessFailure> = _savehooking


    fun save(hooking: Model) {
        val sucessFailure = SucessFailure(true, "")


        if (hooking.id == 0) {
            sucessFailure.sucess = repository.insert(hooking)
        } else {

            sucessFailure.sucess = repository.update(hooking)
        }


        fun get(id: Int) {
            hookingModel.value = repository.get(id)
        }
    }

}
