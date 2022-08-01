package com.mironenko.internship_task_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mironenko.internship_task_1.databinding.ActivityMainBinding
import com.mironenko.internship_task_1.screens.ItemsListFragment

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, ItemsListFragment())
                .commit()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}