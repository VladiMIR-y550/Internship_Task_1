package com.mironenko.internship_task_1

import android.annotation.SuppressLint
import android.app.Application
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class InternshipTask1App : Application() {

    override fun onCreate() {
        super.onCreate()

//        createNotificationChannel();
    }

    @SuppressLint("ServiceCast")
    private fun createNotificationChannel() {
//        val notificationChannel =
//            NotificationChannelCompat.Builder(
//                CHANNEL_ID,
//                NotificationManagerCompat.IMPORTANCE_DEFAULT
//            )
//        val manager = getSystemService(NotificationManagerCompat::class.java)
//        manager.createNotificationChannel(notificationChannel)

        val builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(getString(R.string.app_name))
            .setContentText(getString(R.string.descriptions))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

//        val channel = NotificationChannelCompat.Builder(
//            CHANNEL_ID,
//            NotificationManagerCompat.IMPORTANCE_DEFAULT
//        )

        val channelCompat: NotificationChannelCompat = NotificationChannelCompat.Builder(
            NotificationChannelCompat.DEFAULT_CHANNEL_ID,
            NotificationManagerCompat.IMPORTANCE_DEFAULT
        ) as NotificationChannelCompat
        val notificationManager =
            getSystemService(NOTIFICATION_SERVICE) as NotificationManagerCompat

        val notificationManagerCompat = NotificationManagerCompat.from(applicationContext)
        notificationManagerCompat.createNotificationChannel(channelCompat)
    }
}