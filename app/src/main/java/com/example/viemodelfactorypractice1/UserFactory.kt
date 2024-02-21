package com.example.viemodelfactorypractice1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserFactory (private val userRepository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(userRepository) as T
    }
}