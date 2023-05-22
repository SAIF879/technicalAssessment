package com.example.technicalassessment.screens.home.util

import com.example.assignmentapp.networkService.ApiResult
import com.example.assignmentapp.networkService.CommonApiService
import com.example.assignmentapp.networkService.networkCall
import com.example.technicalassessment.screens.home.model.LinkData
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api : CommonApiService)  {

    suspend fun getData() : ApiResult<LinkData>{
        return networkCall(api.getData())
    }
}