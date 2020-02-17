package com.example.quanlythietbi.di.splash

import androidx.lifecycle.ViewModel
import com.example.quanlythietbi.di.ViewModelKey
import com.example.quanlythietbi.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SplashViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel
}