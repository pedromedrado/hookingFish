package com.example.hookingfish.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.hookingfish.R
import com.example.hookingfish.databinding.ActivityLoginBinding
import com.example.hookingfish.databinding.ActivityRegisterBinding
import com.example.hookingfish.model.Model
import com.example.hookingfish.viewmodel.LoginViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    private lateinit var viewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var userId = 0
        var name = binding.nameRegister.text.toString()
        var email = binding.emailRegister.text.toString()
        var password = binding.passwordRegister.text.toString()
        var btn_register = binding.button

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)


        setSupportActionBar(binding.toolbarCadastro)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)



        btn_register.setOnClickListener {
            var model = Model(userId,name,email,password)
            viewModel.save(model)
        }
    }
}