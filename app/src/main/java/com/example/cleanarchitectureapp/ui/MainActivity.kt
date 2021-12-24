package com.example.cleanarchitectureapp.ui

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.cleanarchitectureapp.R
import com.example.cleanarchitectureapp.databinding.ActivityMainBinding
import com.example.cleanarchitectureapp.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navController = findNavController(R.id.fragment_container_view)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.moviesFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}