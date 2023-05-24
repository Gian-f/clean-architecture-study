package com.example.compose.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose.domain.model.Example
import com.example.compose.domain.usecase.FindExampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(
    private val findExampleUseCase: FindExampleUseCase
) : ViewModel() {
    private val _exampleData = MutableLiveData<List<Example>>()
    val exampleData: LiveData<List<Example>> = _exampleData

    fun getAllExamples() = viewModelScope.launch {
        try {
            val examples = findExampleUseCase.invoke()
            _exampleData.value = examples
        } catch (e: Exception) {
            Log.d("ProductsViewModel", e.toString())
        }
    }
}