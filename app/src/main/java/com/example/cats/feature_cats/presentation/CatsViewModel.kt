package com.example.cats.feature_cats.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cats.core.util.Resource
import com.example.cats.feature_cats.data.remote.dto.Data
import com.example.cats.feature_cats.domain.use_cases.GetCatImages
import com.example.cats.feature_cats.domain.utils.FilterCatDataList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(private val getCatImages: GetCatImages) : ViewModel() {

    var cats = mutableStateListOf<Data>()
        private set

    var isLoading = mutableStateOf(false)
        private set

    var initialState = mutableStateOf(true)
        private set

    var eventFlow = MutableSharedFlow<UIEvent>()
        private set

    fun getCats() {
        initialState.value = false

        viewModelScope.launch {
            getCatImages.invoke().collect { response ->
                when (response) {
                    is Resource.Loading -> {
                        isLoading.value = true
                    }

                    is Resource.Success -> {
                        response.data?.let {
                            val filtered = FilterCatDataList.onlyImages(it.data)
                            cats.addAll(filtered) }
                        isLoading.value = false
                    }

                    is Resource.Error -> {
                        isLoading.value = false
                        initialState.value = true
                        response.message?.let { eventFlow.emit(UIEvent.ShowSnackbar(it)) }
                    }
                }
            }
        }
    }

    sealed class UIEvent {
        data class ShowSnackbar(val message: String) : UIEvent()
    }
}