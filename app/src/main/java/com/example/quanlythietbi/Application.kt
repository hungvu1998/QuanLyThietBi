package com.example.quanlythietbi

import dagger.android.AndroidInjector
import com.example.quanlythietbi.di.AppComponent
import com.example.quanlythietbi.di.DaggerAppComponent
import dagger.android.support.DaggerApplication

class Application : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}