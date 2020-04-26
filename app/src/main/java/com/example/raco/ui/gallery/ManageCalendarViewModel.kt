package com.example.raco.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ManageCalendarViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "All the Calendar actions are planned here."
    }
    val text: LiveData<String> = _text
}