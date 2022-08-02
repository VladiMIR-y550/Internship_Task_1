package com.mironenko.internship_task_1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AppBroadcastReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.startActivity(Intent(context, MainActivity::class.java))
    }
}