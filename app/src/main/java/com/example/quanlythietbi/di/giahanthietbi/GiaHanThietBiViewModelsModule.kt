package com.example.quanlythietbi.di.giahanthietbi

import androidx.lifecycle.ViewModel
import com.example.quanlythietbi.di.ViewModelKey
import com.example.quanlythietbi.ui.giahan.GiaHanThietBiViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class GiaHanThietBiViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(GiaHanThietBiViewModel::class)
    abstract fun bindGiaHanThietBiViewModel(giaHanThietBiViewModel: GiaHanThietBiViewModel): ViewModel
}