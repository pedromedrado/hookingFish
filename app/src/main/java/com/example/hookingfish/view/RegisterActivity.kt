package com.example.hookingfish.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.hookingfish.R
import com.example.hookingfish.databinding.ActivityLoginBinding
import com.example.hookingfish.databinding.ActivityRegisterBinding
import com.example.hookingfish.model.Model
import com.example.hookingfish.util.Login
import com.example.hookingfish.viewmodel.LoginViewModel

class RegisterActivity : AppCompatActivity(), Login.View {
    private lateinit var binding : ActivityRegisterBinding
    private lateinit var viewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var userId = 0

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.attachView(this)

        setSupportActionBar(binding.toolbarCadastro)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)



        binding.btnRegister.setOnClickListener {
            viewModel.register( binding.emailRegister.text.toString(),binding.nameRegister.text.toString(),binding.passwordRegister.text.toString())
        }
    }

    override fun showProgress(enabled: Boolean) {

    }

    override fun displayEmailFailure(emailError: Int?) {
        binding.inputRegisterEmail1.error = emailError?.let { getString(it) }
    }

    override fun displayNameFailure(nameError: Int?) {
        binding.inputRegisterName.error = nameError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding.inputPasswordRegister.error = passwordError?.let { getString(it) }
    }

    override fun onUserAuthenticated() {

    }

    override fun onUserUnauthorized(message: String) {

    }

    override fun onUserRegisted() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}