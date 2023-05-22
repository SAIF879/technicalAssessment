package com.example.technicalassessment.screens.home.util

import com.example.assignmentapp.networkService.ApiResult
import com.example.assignmentapp.networkService.CommonApiService
import com.example.assignmentapp.networkService.networkCall
import com.example.assignmentapplisted.home.data.OpenInDAO
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api : CommonApiService)  {

    suspend fun getData() : ApiResult<OpenInDAO>{
        return networkCall(api.getData())
    }
}