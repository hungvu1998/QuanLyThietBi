package com.example.quanlythietbi.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.example.quanlythietbi.R
import com.example.quanlythietbi.ui.giahan.GiaHanThietBiActivity
import com.example.quanlythietbi.viewmodels.ViewModelProvidersFactory
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.layout_login.*
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity(), GoogleApiClient.OnConnectionFailedListener{


    @Inject
    lateinit var providerFactory: ViewModelProvidersFactory

    val firebaseAuth: FirebaseAuth=FirebaseAuth.getInstance()
    lateinit var apiClient : GoogleApiClient
    val REQUESTCODE_LOGIN_GOOOGLE=100
    var PROVIDER_DANGNHAP=0

    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)
        viewModel= ViewModelProviders.of(this,providerFactory).get(LoginViewModel::class.java)
        CreateClientLoginGG()
        btnLoginEmail?.setOnClickListener {
            LoginGG(apiClient)
        }
        btnLoginVerify?.setOnClickListener {
            val intent = Intent(this,GiaHanThietBiActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
    override fun onConnectionFailed(p0: ConnectionResult) {

    }
    private fun LoginGG(apiClient: GoogleApiClient) {
        PROVIDER_DANGNHAP = 1
        val intentGG = Auth.GoogleSignInApi.getSignInIntent(apiClient)
        startActivityForResult(intentGG, REQUESTCODE_LOGIN_GOOOGLE)
    }
    fun CreateClientLoginGG(){
        val signInOptions = GoogleSignInOptions.Builder()
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        apiClient = GoogleApiClient.Builder(this)
            .enableAutoManage(this, this)

            .addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions)
            .build()
    }
    private fun ProvideFirebase(tokenid: String) {

        if (PROVIDER_DANGNHAP == 1) {
            val authCredential = GoogleAuthProvider.getCredential(tokenid, null)
            firebaseAuth.signInWithCredential(authCredential)
        }

    }

    override fun onStart() {
        super.onStart()
        firebaseAuth.signOut()

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUESTCODE_LOGIN_GOOOGLE) {
            if (resultCode == Activity.RESULT_OK) {
                val signInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
                val googleSignInAccount = signInResult.signInAccount
                val tokenID = googleSignInAccount!!.idToken
                apiClient.clearDefaultAccountAndReconnect()
                ProvideFirebase(tokenID!!)
                val intent = Intent(this,GiaHanThietBiActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}