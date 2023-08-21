package com.example.weather

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.ui.config.LocalConfigSave
import com.example.weather.ui.home.HomeViewModel
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var homeViewModel: HomeViewModel
    private var localConfig: LocalConfigSave? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        localConfig = LocalConfigSave(this)

        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        homeViewModel.drawerLayoutState.observe(this) {
            if (it) {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.layoutContainer)
        navView.setupWithNavController(navController)

        if(localConfig?.defaultConfig() == true){
            navController.navigate(R.id.nav_home)
        }

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> {navController.navigate(R.id.nav_home)}
                R.id.nav_location -> {navController.navigate(R.id.nav_location)}
                R.id.nav_config -> {navController.navigate(R.id.nav_config)}
                R.id.nav_share -> {navController.navigate(R.id.nav_share)}
                R.id.nav_notification -> {navController.navigate(R.id.nav_notification)}
                R.id.nav_mail -> {navController.navigate(R.id.nav_mail)}
                R.id.nav_user -> {navController.navigate(R.id.nav_user)}
                R.id.nav_info -> {navController.navigate(R.id.nav_info)}
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }
}