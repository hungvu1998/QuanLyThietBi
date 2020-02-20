package com.example.quanlythietbi.ui.giahan

import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.quanlythietbi.R

import kotlinx.android.synthetic.main.layout_giahan_thietbi.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class GiaHanThietBiViewModel
@Inject
constructor(

) : ViewModel(){
    val DATE_FORMAT = "EEE, MMM d, yyyy"
    val dateFormatter = SimpleDateFormat(DATE_FORMAT)
    var callerId=-1
    var currentYear=0
    var currentMonth = 0
    var currentDay =0

    private var mNavigator: GiaHanThietBiNavigator? = null


    fun getNavigator(): GiaHanThietBiNavigator? {
        return mNavigator
    }

    fun setNavigator(navigator: GiaHanThietBiNavigator) {
        this.mNavigator = navigator
    }

    fun getDateCurrent(callerId:Int){
        this.callerId=callerId
        val calendar = Calendar.getInstance()

         this.currentYear = calendar.get(Calendar.YEAR)
         this.currentMonth = calendar.get(Calendar.MONTH) // calendar month 0-11
         this.currentDay = calendar.get(Calendar.DATE)
        handleOnDateSet(currentYear,currentMonth,currentDay)
        getNavigator()?.enableButton(false)

    }

    fun showDatePickerDialog( callerId:Int,context: Context,dateText:String) {
        this.callerId=callerId
        var date: Date? = null
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
            val datePicker = DatePickerDialog(context,
                DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                    if(year<currentYear ){
                        getNavigator()?.setErro()
                    } else if (month<currentMonth){
                        getNavigator()?.setErro()
                    }
                    else if(month == currentMonth){
                        if(day<currentDay)
                            getNavigator()?.setErro()
                        else
                            handleOnDateSet(year, month, day)
                    }
                    else{
                        handleOnDateSet(year, month, day)
                    }

                }, year, month, day)
            datePicker.setTitle("My date picker")

            datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ok", datePicker)
            datePicker.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel") { dialogInterface, i ->
            }
            datePicker.show()
    }
    fun handleOnDateSet(year: Int, month: Int, day: Int) {

        val date = GregorianCalendar(year, month, day).getTime()
        val formatedDate = dateFormatter.format(date)
        getNavigator()?.setText(formatedDate,callerId)
        if(callerId==R.id.tvFromDate)
            getNavigator()?.enableButton(true)

    }


}