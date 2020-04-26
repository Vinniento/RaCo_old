package com.example.raco.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TrainingsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Trainings can be viewed here."
    }
    val text: LiveData<String> = _text
}