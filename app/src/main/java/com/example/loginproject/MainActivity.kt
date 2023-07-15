package com.example.loginproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.loginproject.file.FileManager
import com.example.loginproject.user.PasswordType
import com.example.loginproject.user.User
import com.example.loginproject.user.UserManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UserManager.sharedInstance(this).loadAllUserInfo()
        UserManager.sharedInstance(this).login("jack","123",PasswordType.LoginType_Pin)
    }
}