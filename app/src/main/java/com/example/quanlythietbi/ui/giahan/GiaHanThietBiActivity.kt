package com.example.quanlythietbi.ui.giahan

import android.os.Bundle
import com.example.quanlythietbi.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.layout_giahan_thietbi.*
import java.text.SimpleDateFormat
import java.util.*
import android.content.DialogInterface
import android.app.DatePickerDialog
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.quanlythietbi.viewmodels.ViewModelProvidersFactory
import javax.inject.Inject


class GiaHanThietBiActivity : DaggerAppCompatActivity(),GiaHanThietBiNavigator{


    @Inject
    lateinit var providerFactory: ViewModelProvidersFactory

    lateinit var viewModel: GiaHanThietBiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_giahan_thietbi)
        viewModel= ViewModelProviders.of(this,providerFactory).get(GiaHanThietBiViewModel::class.java)
        viewModel.setNavigator(this)
        viewModel.getDateCurrent(R.id.tvToDate)

        tvToDate?.setOnClickListener {
            viewModel.showDatePickerDialog(R.id.tvToDate,this,tvToDate?.text.toString().trim { it <= ' ' })
        }
        tvFromDate?.setOnClickListener {
            viewModel.showDatePickerDialog(R.id.tvFromDate,this,tvFromDate?.text.toString().trim { it <= ' ' })
        }

    }
    override fun setErro() {
        Toast.makeText(this,"Yêu cầu chọn lại ngày phù hợp", Toast.LENGTH_SHORT).show()
    }
    override fun enableButton(boolean: Boolean) {
        if(boolean){
            btnOke?.isEnabled=true
            btnOke?.setBackgroundResource(R.drawable.button_radius_gg)

        }else{
            btnOke?.isEnabled=false
            btnOke?.setBackgroundResource(R.drawable.button_radius_gg_enable)
        }
    }

    override fun setText(date:String,callerId:Int) {
        when (callerId) {
            R.id.tvToDate -> tvToDate.text = date
            R.id.tvFromDate -> tvFromDate.text = date
        }
    }



}