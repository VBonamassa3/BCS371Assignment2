package com.example.assignment2

import androidx.lifecycle.ViewModel

class AppInfoViewModel(var appRepository: BookRepository) : ViewModel(){
    fun obtainAppName(): String{
        return appRepository.getAppData()
    }
    fun obtainDevName(): String{
        return appRepository.getAppDeveloperName()
    }
    fun obtainVersion(): String{
        return appRepository.getAppVersion()
    }
}