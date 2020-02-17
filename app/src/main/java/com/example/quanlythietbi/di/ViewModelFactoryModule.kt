package com.example.quanlythietbi.di

import androidx.lifecycle.ViewModelProvider
import com.example.quanlythietbi.viewmodels.ViewModelProvidersFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory: ViewModelProvidersFactory): ViewModelProvider.Factory

}