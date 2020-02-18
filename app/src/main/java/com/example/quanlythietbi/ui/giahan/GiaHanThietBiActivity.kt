package com.example.quanlythietbi.ui.giahan

import android.os.Bundle
import com.example.quanlythietbi.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.layout_giahan_thietbi.*
import java.text.SimpleDateFormat
import java.util.*
import android.content.DialogInterface
import android.app.DatePickerDialog
import android.widget.TextView






class GiaHanThietBiActivity : DaggerAppCompatActivity(){
    val DATE_FORMAT = "EEE, MMM d, yyyy"
    val dateFormatter = SimpleDateFormat(DATE_FORMAT)
    var callerId  =-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_giahan_thietbi)
        tvToDate?.setOnClickListener {
            showDatePickerDialog(R.id.tvToDate, tvToDate?.text.toString().trim { it <= ' ' })
        }
        tvFromDate?.setOnClickListener {
            showDatePickerDialog(R.id.tvFromDate, tvFromDate?.text.toString().trim { it <= ' ' })
        }

    }
     fun showDatePickerDialog(callerId:Int, dateText:String) {
         this.callerId = callerId
         var date:Date? = null
         try
         {
             if (dateText == "")
                 date = Date()
             else
                 date = dateFormatter.parse(dateText)
         }
         catch (exp:Exception) {
             date = Date()
         }
         val calendar = Calendar.getInstance()
         calendar.time = date
         val year = calendar.get(Calendar.YEAR)
         val month = calendar.get(Calendar.MONTH) // calendar month 0-11
         val day = calendar.get(Calendar.DATE)

        val datePicker = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { datePicker, year, month, day -> handleOnDateSet(year, month, day) }, year, month, day)
         datePicker.setTitle("My date picker")

         datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ok", datePicker)
         datePicker.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel") { dialogInterface, i ->


         }
         datePicker.show()
     }

    fun handleOnDateSet(year: Int, month: Int, day: Int) {
        val date = GregorianCalendar(year, month, day).getTime()
        val formatedDate = dateFormatter.format(date)

        when (callerId) {
            R.id.tvToDate -> tvToDate.text = formatedDate
            R.id.tvFromDate -> tvFromDate.text = formatedDate
        }
    }
}