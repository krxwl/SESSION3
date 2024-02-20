package com.github.krxwl.session3.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.github.krxwl.session3.R
import com.github.krxwl.session3.databinding.ActivityMainBinding
import com.github.krxwl.session3.fragments.HomeFragment
import com.github.krxwl.session3.fragments.ProfileFragment
import com.github.krxwl.session3.viewmodels.MainViewModel
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.itemIconTintList = null
        binding.bottomNavigationView.labelVisibilityMode =
            NavigationBarView.LABEL_VISIBILITY_LABELED

        val currentFrag = supportFragmentManager.findFragmentById(R.id.bottom_navigation_frag)
        if (currentFrag != null) {
            supportFragmentManager.beginTransaction().add(R.id.bottom_navigation_frag, viewModel.getHomeFragment())
                .commit()
        }

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.bottom_navigation_frag, viewModel.getProfileFragment()).commit()
                    true
                }
                R.id.bottom_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.bottom_navigation_frag, viewModel.getHomeFragment()).commit()
                    true
                }
                R.id.bottom_wallet -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.bottom_navigation_frag, viewModel.getWalletFragment()).commit()
                    true
                }
                R.id.bottom_track -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.bottom_navigation_frag, viewModel.getTrackFragment()).commit()
                    true
                }
                else-> false
            }
        }
    }
}

