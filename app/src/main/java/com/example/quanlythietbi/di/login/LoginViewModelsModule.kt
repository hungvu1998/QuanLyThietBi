package com.example.quanlythietbi.di.login

import androidx.lifecycle.ViewModel
import com.example.quanlythietbi.di.ViewModelKey
import com.example.quanlythietbi.ui.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindAuthViewModel(loginViewModel: LoginViewModel): ViewModel
}