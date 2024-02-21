package com.example.viemodelfactorypractice1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel (private val userRepository: UserRepository) : ViewModel() {

    var userMutableLiveData : MutableLiveData<List<User>> = MutableLiveData()

    fun getData(){
        val response = userRepository.getAllData()
        userMutableLiveData.value = response
    }

}