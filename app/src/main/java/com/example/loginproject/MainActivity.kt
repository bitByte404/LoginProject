package com.example.loginproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.loginproject.file.FileManager
import com.example.loginproject.user.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val users = listOf(
            User("jack","123","456",false),
            User("rose","252","247",false)
        )
        FileManager.sharedInstance().readData(this).also {
            it.forEach { user ->
                Log.v("pxd","$user")
            }
        }
    }
}