package com.dyshuk.android.factnumbers.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NumbersViewModel(application: Application) : AndroidViewModel(application) {

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NumbersViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return NumbersViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct ViewModel")
        }
    }
}