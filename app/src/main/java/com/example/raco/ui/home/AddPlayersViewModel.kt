package com.example.raco.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddPlayersViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Players can be added here."
    }
    val text: LiveData<String> = _text
}