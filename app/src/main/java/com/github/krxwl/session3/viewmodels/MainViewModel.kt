package com.github.krxwl.session3.viewmodels

import androidx.lifecycle.ViewModel
import com.github.krxwl.session3.fragments.HomeFragment
import com.github.krxwl.session3.fragments.ProfileFragment
import com.github.krxwl.session3.fragments.TrackFragment
import com.github.krxwl.session3.fragments.WalletFragment

class MainViewModel : ViewModel() {
    private val profileFragment = ProfileFragment()
    private val homeFragment = HomeFragment()
    private val trackFragment = TrackFragment()
    private val walletFragment = WalletFragment()

    fun getProfileFragment() = profileFragment
    fun getHomeFragment() = homeFragment
    fun getTrackFragment() = trackFragment
    fun getWalletFragment() = walletFragment
}