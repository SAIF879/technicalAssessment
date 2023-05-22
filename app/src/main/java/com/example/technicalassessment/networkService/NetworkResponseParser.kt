package com.example.assignmentapp.networkService


import android.util.Log
import retrofit2.Response
import kotlin.math.log

//Do not remove suspend from here.
suspend fun <T : Any> networkCall(response: Response<T>): ApiResult<T> {
    Log.d("fnksldfnsdklf",response.body().toString())
    return if (response.isSuccessful) {
        response.body()?.let { ApiResult.Success(response.body()) }
            ?: ApiResult.Error("empty response body")
    }
    else
        ApiResult.Error(response.message())
}


