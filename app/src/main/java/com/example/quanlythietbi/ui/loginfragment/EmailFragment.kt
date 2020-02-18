package com.example.quanlythietbi.ui.loginfragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.quanlythietbi.R

class EmailFragment : Fragment() {

    companion object {
        fun newInstance() = EmailFragment()
    }

    private lateinit var viewModel: EmailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.email_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EmailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
