package com.example.hookingfish.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hookingfish.common.util.TxtWatcher
import com.example.hookingfish.databinding.ActivityLoginBinding
import com.example.hookingfish.model.Model
import com.example.hookingfish.util.Login
import com.example.hookingfish.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity(), Login.View {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    var loginid = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.attachView(this)


        binding.editEmail.addTextChangedListener(watcher)
        //apaga o campo apos o erro do usuario ao colocar  usuario
        binding.editEmail.addTextChangedListener(TxtWatcher{displayEmailFailure(null)})
        binding.editPassword.addTextChangedListener(watcher)
        binding.editPassword.addTextChangedListener(TxtWatcher{displayEmailFailure(null)})
        observe()

        binding.enter.setOnClickListener {
            viewModel.login(binding.editEmail.text.toString(),binding.editPassword.text.toString())
        }

        binding.txtRegister.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }

    private val watcher = TxtWatcher {
        binding.enter.isEnabled = binding.editEmail.text.toString().isNotEmpty()&&
                binding.editPassword.text.toString().isNotEmpty()

    }


    private fun observe() {
        viewModel.hooking.observe(this, Observer {
            binding.editEmail.setText(it.name)
            binding.editPassword.setText(it.password)

        })


    }

    override fun showProgress(enabled: Boolean) {

    }

    override fun displayEmailFailure(emailError: Int?) {
        binding.inputEmail.error = emailError?.let { getString(it) }

    }

    override fun displayNameFailure(nameError: Int?) {

    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding.inputPassword.error = passwordError?.let { getString(it) }
    }

    override fun onUserAuthenticated() {
        startActivity(Intent(this,MainActivity::class.java))
    }

    override fun onUserUnauthorized(message: String) {

    }

    override fun onUserRegisted() {
        startActivity(Intent(this,MainActivity::class.java))

    }
}