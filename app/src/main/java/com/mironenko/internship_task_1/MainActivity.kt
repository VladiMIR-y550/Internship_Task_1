package com.mironenko.internship_task_1

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mironenko.internship_task_1.databinding.ActivityMainBinding
import com.mironenko.internship_task_1.screens.detail.ItemDetailFragment
import com.mironenko.internship_task_1.screens.list.ItemsListFragment

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!
    private val appReceiver = AppBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initReceiver()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, ItemsListFragment())
                .commit()
        }

        if (getItemIdFromIntent() != DEFAULT_VALUE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ItemDetailFragment.newInstance(getItemIdFromIntent()))
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroy() {
        _binding = null
        unregisterReceiver(appReceiver)
        super.onDestroy()
    }

    private fun initReceiver() {
        val filter = IntentFilter(ACTION_NOTIFICATION_CLICKED)
        registerReceiver(appReceiver, filter)
    }

    private fun getItemIdFromIntent(): Int =
        if (intent.hasExtra(Intent.EXTRA_TEXT)) intent.getIntExtra(Intent.EXTRA_TEXT, DEFAULT_VALUE) else DEFAULT_VALUE
}