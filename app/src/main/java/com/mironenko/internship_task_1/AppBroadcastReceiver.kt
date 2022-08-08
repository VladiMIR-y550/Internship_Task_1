package com.mironenko.internship_task_1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.mironenko.internship_task_1.util.DEFAULT_VALUE
import com.mironenko.internship_task_1.util.PREFERENCE_FILE_KEY
import com.mironenko.internship_task_1.util.SAVED_ITEM_ID

class AppBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val sharedPrefItemId =
            context?.getSharedPreferences(PREFERENCE_FILE_KEY, Context.MODE_PRIVATE)?.getInt(
                SAVED_ITEM_ID, DEFAULT_VALUE
            )

        val intentId = Intent(context, MainActivity::class.java)
        intentId.putExtra(Intent.EXTRA_TEXT, sharedPrefItemId)
        context?.startActivity(intentId)
    }
}