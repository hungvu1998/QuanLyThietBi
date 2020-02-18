package com.example.quanlythietbi.ui.loginfragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.quanlythietbi.R

class ExpressFragment : Fragment() {

    companion object {
        fun newInstance() = ExpressFragment()
    }

    private lateinit var viewModel: ExpressViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.express_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExpressViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
