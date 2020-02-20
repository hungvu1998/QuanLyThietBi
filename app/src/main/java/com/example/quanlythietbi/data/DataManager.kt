package com.example.quanlythietbi.data

import com.example.quanlythietbi.data.local.db.DbHelper
import com.example.quanlythietbi.data.local.prefs.PreferencesHelper
import com.example.quanlythietbi.data.remote.ApiHelper
import io.reactivex.Observable

interface DataManager : DbHelper, PreferencesHelper, ApiHelper {

    //val questionCardData: Observable<List<QuestionCardData>>

    fun seedDatabaseOptions(): Observable<Boolean>

    fun seedDatabaseQuestions(): Observable<Boolean>

    fun setUserAsLoggedOut()

    fun updateApiHeader(userId: Long?, accessToken: String)

    fun updateUserInfo(
        accessToken: String,
        userId: Long?,
        loggedInMode: LoggedInMode,
        userName: String,
        email: String,
        profilePicPath: String
    )

    enum class LoggedInMode private constructor(val type: Int) {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3)


    }
}
