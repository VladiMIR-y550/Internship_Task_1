package com.mironenko.internship_task_1

import android.app.*
import android.content.Intent
import android.os.Build
import android.os.IBinder

class AppService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        showNotification()
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            START_NOT_STICKY
        } else {
            START_STICKY
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopSelf()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(
                NotificationManager::class.java
            )
            manager.createNotificationChannel(serviceChannel)
        }
    }

    private fun showNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val broadcastIntent = Intent(ACTION_NOTIFICATION_CLICKED)

            val pendingIntent = PendingIntent.getBroadcast(
                this, 0, broadcastIntent, PendingIntent.FLAG_IMMUTABLE
            )

            val notification = Notification
                .Builder(this, CHANNEL_ID)
                .setContentText(getString(R.string.app_name))
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .build()

            startForeground(NOTIFICATION_ID, notification)
        }
    }
}