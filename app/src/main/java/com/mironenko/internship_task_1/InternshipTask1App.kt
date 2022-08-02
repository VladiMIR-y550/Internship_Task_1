package com.mironenko.internship_task_1

import android.app.Application
import android.content.Intent

class InternshipTask1App : Application() {

    override fun onCreate() {
        super.onCreate()
        startService(Intent(this, AppService::class.java))
    }
}