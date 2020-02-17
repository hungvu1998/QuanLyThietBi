package com.example.quanlythietbi.di

import com.example.quanlythietbi.di.login.LoginModule
import com.example.quanlythietbi.di.login.LoginViewModelsModule
import com.example.quanlythietbi.di.splash.SplashModule
import com.example.quanlythietbi.di.splash.SplashViewModelsModule
import com.example.quanlythietbi.ui.login.LoginActivity
import com.example.quanlythietbi.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector(modules = [SplashViewModelsModule::class, SplashModule::class])
    abstract fun contributeSplashActivity(): SplashActivity
    @ContributesAndroidInjector(modules = [LoginViewModelsModule::class, LoginModule::class])
    abstract fun contributeLoginActivity(): LoginActivity
}