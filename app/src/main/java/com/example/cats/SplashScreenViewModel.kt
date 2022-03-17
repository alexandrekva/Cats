package com.example.cats

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenViewModel : ViewModel() {

    var isLoading = mutableStateOf(true)
        private set

    init {
        viewModelScope.launch {
            delay(600)
            isLoading.value = false
        }
    }
}