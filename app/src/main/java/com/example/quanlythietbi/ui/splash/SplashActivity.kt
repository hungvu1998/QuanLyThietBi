package com.example.quanlythietbi.ui.splash

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.example.quanlythietbi.R
import com.example.quanlythietbi.ui.login.LoginActivity
import com.example.quanlythietbi.viewmodels.ViewModelProvidersFactory
import dagger.android.support.DaggerAppCompatActivity
import java.lang.Exception
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity(),SplashNavigator{


    @Inject
    lateinit var providerFactory: ViewModelProvidersFactory
    lateinit var viewModel: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_splash)
        viewModel= ViewModelProviders.of(this,providerFactory).get(SplashViewModel::class.java)
        viewModel.setNavigator(this)
        viewModel.getNavigator()?.runInThread()

    }
    override fun runInThread() {
        Log.d("kiemtra","fffffff")

        val thread = object :Thread(){
            override fun run() {
                try {
                    Thread.sleep(5000)
                    val intent = Intent(this@SplashActivity,LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        thread.start()

    }
}