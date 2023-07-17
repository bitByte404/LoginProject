package com.example.loginproject.app

import android.app.Application
import com.example.loginproject.user.UserManager

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        //加载所有用户信息
        UserManager.sharedInstance(this).loadAllUserInfo()
    }
}