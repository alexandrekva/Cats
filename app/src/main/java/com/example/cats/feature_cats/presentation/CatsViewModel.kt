package com.example.cats.feature_cats.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cats.core.util.Resource
import com.example.cats.feature_cats.data.remote.dto.Data
import com.example.cats.feature_cats.domain.use_cases.GetCatImages
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(private val getCatImages: GetCatImages) : ViewModel() {

    var cats = mutableStateListOf<Data>()
        private set

    var isLoading = mutableStateOf(false)
        private set

    fun getCats() {
        viewModelScope.launch {
            getCatImages.invoke().collect { response->
                when (response) {
                    is Resource.Loading -> {
                        isLoading.value = true
                    }

                    is Resource.Success -> {
                        response.data?.let { cats.addAll(it.data) }
                        isLoading.value = false
                    }

                    is Resource.Error -> {
                        isLoading.value = false
                    }
                }

            }
        }
    }
}