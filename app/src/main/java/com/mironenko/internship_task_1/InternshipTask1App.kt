package com.mironenko.internship_task_1

import android.app.Application
import android.content.Intent
import android.os.Build

class InternshipTask1App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(Intent(this, AppService::class.java))
        }
    }
}