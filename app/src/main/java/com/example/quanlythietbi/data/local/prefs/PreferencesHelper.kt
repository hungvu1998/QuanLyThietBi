package com.example.quanlythietbi.data.local.prefs

import com.example.quanlythietbi.data.DataManager

interface PreferencesHelper {

    var accessToken: String

    var currentUserEmail: String

    var currentUserId: Long?

    val currentUserLoggedInMode: Int

    var currentUserName: String

    var currentUserProfilePicUrl: String

    fun setCurrentUserLoggedInMode(mode: DataManager.LoggedInMode)
}
