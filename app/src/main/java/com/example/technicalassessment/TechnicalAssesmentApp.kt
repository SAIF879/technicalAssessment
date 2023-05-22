package com.example.technicalassessment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TechnicalAssesmentApp : Application() {
    companion object{
        @JvmStatic
        var instance :  TechnicalAssesmentApp? = null
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}