package com.example.quanlythietbi.ui.splash

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProviders
import com.example.quanlythietbi.R
import com.example.quanlythietbi.ui.login.LoginActivity
import com.example.quanlythietbi.viewmodels.ViewModelProvidersFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.layout_splash.*
import java.lang.Exception
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity(),SplashNavigator{

    @Inject
    lateinit var providerFactory: ViewModelProvidersFactory
    lateinit var viewModel: SplashViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_splash)
        var zoomOutAnim: Animation = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_out)

        viewModel= ViewModelProviders.of(this,providerFactory).get(SplashViewModel::class.java)
        viewModel.setNavigator(this)
        viewModel.getNavigator()?.runInThread()


    }
    override fun runInThread() {

        val thread = object :Thread(){
            override fun run() {
                try {

                    Thread.sleep(2000)
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