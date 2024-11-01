package com.example.hookingfish.viewmodel

import android.app.Application
import android.content.Intent
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.hookingfish.R
import com.example.hookingfish.model.Model
import com.example.hookingfish.model.SucessFailure
import com.example.hookingfish.repository.HookingRepository
import com.example.hookingfish.util.Login
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel (application: Application)  : AndroidViewModel(application), Login.ViewModelLogin {

    private var view: Login.View? = null
    private val auth = FirebaseAuth.getInstance()
    private val repository = HookingRepository.getInstance(application)

    private val model = MutableLiveData<Model>()
    val hooking: LiveData<Model> = model

    fun attachView(loginView: Login.View) {
        view = loginView
    }


    fun save(data: Model) {
        val sucessoFailure = SucessFailure(true, "")

        if (data.id == 0) {
            sucessoFailure.sucess = repository.insert(data)
        } else {
            Toast.makeText(getApplication(), "Nao foi foi criado ", Toast.LENGTH_SHORT).show()
        }

    }

    override fun login(email: String, password: String) {

        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length >= 8

        if (email.isEmpty() && password.isEmpty()) {
            Toast.makeText(getApplication(), "Preencha E-mail e Senha", Toast.LENGTH_SHORT).show()
        } else {
            if (!isEmailValid) {
                view?.displayEmailFailure(R.string.invalid_email)

            } else {
                view?.displayEmailFailure(null)
            }


            if (!isPasswordValid) {
                view?.displayPasswordFailure(R.string.invalid_password)
            } else {
                view?.displayPasswordFailure(null)
            }


            if (isEmailValid && isPasswordValid) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            view?.onUserAuthenticated()
                        } else {
                            Toast.makeText(getApplication(), "Usuário não localizado", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

    }

     fun register(email: String, name: String, password: String) {

        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isNameValid = name.length >= 5
        val isPasswordValid = password.length >= 8

        if (email.isEmpty() && password.isEmpty() && name.isEmpty()) {
            Toast.makeText(getApplication(), "Preencha seus dados", Toast.LENGTH_SHORT).show()
        } else {
            if (!isEmailValid) {
                view?.displayEmailFailure(R.string.invalid_email)

            } else {
                view?.displayEmailFailure(null)
            }

            if (!isNameValid) {
                view?.displayNameFailure(R.string.invalid_name)

            } else {
                view?.displayNameFailure(null)
            }

            if (!isPasswordValid) {
                view?.displayPasswordFailure(R.string.invalid_password)
            } else {
                view?.displayPasswordFailure(null)
            }


            if (isEmailValid && isPasswordValid) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            view?.onUserRegisted()
                            Toast.makeText(getApplication(), "Usuário Cadastrado", Toast.LENGTH_SHORT).show()
                        } else {
                            view?.displayEmailFailure(R.string.invalid_date)
                            view?.displayNameFailure(R.string.invalid_date)
                            view?.displayNameFailure(R.string.invalid_date)

                        }
                    }


            }

        }


    }
}