package com.example.technicalassessment.screens.home.util

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentapp.networkService.ApiResult
import com.example.technicalassessment.screens.home.model.LinkData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    private val _homeData = MutableLiveData<ApiResult<LinkData>>()
     val homeData : MutableLiveData<ApiResult<LinkData>>
     get() = _homeData

    fun getHomeData() {
        homeData.value = ApiResult.Loading
        viewModelScope.launch {
            _homeData.value = repository.getData()
        }
    }
}