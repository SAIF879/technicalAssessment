package com.example.assignmentapp.networkService



import com.example.assignmentapplisted.home.data.OpenInDAO
import retrofit2.Response
import retrofit2.http.GET

interface CommonApiService  {
    @GET("/api//v1/dashboardNew")
    suspend fun getData() : Response<OpenInDAO>
}