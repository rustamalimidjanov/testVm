package com.example.testvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentNameViewModel: ViewModel() {

    private val _mutableNameText: MutableLiveData<Name> = MutableLiveData<Name>()
    val mutableNameText: LiveData<Name> = _mutableNameText


    fun saveNewName(text: String) {
        _mutableNameText.value = Name(name = text)
    }

}