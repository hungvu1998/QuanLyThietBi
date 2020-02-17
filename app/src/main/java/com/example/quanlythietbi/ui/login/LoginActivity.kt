package com.example.quanlythietbi.ui.login

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.quanlythietbi.R
import com.example.quanlythietbi.viewmodels.ViewModelProvidersFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity(){

    @Inject
    lateinit var providerFactory: ViewModelProvidersFactory

    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)
        viewModel= ViewModelProviders.of(this,providerFactory).get(LoginViewModel::class.java)
    }
}