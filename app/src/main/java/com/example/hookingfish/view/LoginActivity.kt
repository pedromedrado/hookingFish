package com.example.hookingfish.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hookingfish.databinding.ActivityLoginBinding
import com.example.hookingfish.model.Model
import com.example.hookingfish.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    var loginid = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        observe()

        binding.button.setOnClickListener {


            var email = binding.email1.text.toString()
            var password = binding.editpassword.text.toString()
            var name = "Paulo"

            var model = Model(loginid, name, email, password)
            viewModel.save(model)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        binding.txtRegister.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }


    private fun observe() {
        viewModel.hooking.observe(this, Observer {
            binding.email1.setText(it.name)
            binding.editpassword.setText(it.password)

        })


    }


}