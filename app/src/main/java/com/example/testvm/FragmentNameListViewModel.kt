package com.example.testvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentNameListViewModel: ViewModel() {

    private val _mutableNameListText = MutableLiveData<List<NameList>>()
    val mutableNameListText: LiveData<List<NameList>> =_mutableNameListText

    fun saveNameList(firstName: String, lastName: String, age: Int) {
        _mutableNameListText.value = listOf(
            NameList(
                firstName = firstName,
                lastName = lastName,
                age = age,
            )
        )
    }

}