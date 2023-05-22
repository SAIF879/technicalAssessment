package com.example.assignmentapp.networkService



import com.example.technicalassessment.screens.home.model.LinkData
import retrofit2.Response
import retrofit2.http.GET

interface CommonApiService  {

    @GET("/v1/dashboardNew")
    suspend fun getData() : Response<LinkData>
}