package com.example.testvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel: ViewModel() {
    val mutableText: MutableLiveData<Name> by lazy {
        MutableLiveData<Name>()
    }

    fun saveNewName(text: String) {
        mutableText.value = Name(name = text)
    }

}