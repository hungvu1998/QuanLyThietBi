package com.example.quanlythietbi.ui.splash

import androidx.lifecycle.ViewModel
import javax.inject.Inject


class SplashViewModel  @Inject
constructor(): ViewModel() {


    private var mNavigator: SplashNavigator? = null


    fun getNavigator(): SplashNavigator? {
        return mNavigator
    }

    fun setNavigator(navigator: SplashNavigator) {
        this.mNavigator = navigator
    }


}

