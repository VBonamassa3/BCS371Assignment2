package com.example.assignment2

import android.app.Application

class MyApp : Application() {
    companion object {
        lateinit var x: BookRepository
    }
    override fun onCreate() {
        super.onCreate()
        x = BookRepository()
    }
}