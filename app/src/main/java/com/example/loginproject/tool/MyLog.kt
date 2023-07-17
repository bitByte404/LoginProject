package com.example.loginproject.tool

import android.util.Log

//v i d e w e
object MyLog {
    private const val IS_RELEASE = true

    fun v(content:String , tag:String = "pxd"){
        if (!IS_RELEASE) {
            Log.v(tag,content)
        }
    }

    fun i(tag:String = "pxd",content:String = ""){
        if (!IS_RELEASE) {
            Log.i(tag,content)
        }
    }

    fun d(tag:String = "pxd",content:String = ""){
        if (!IS_RELEASE) {
            Log.d(tag,content)
        }
    }

    fun e(tag:String = "pxd",content:String = ""){
        if (!IS_RELEASE) {
            Log.e(tag,content)
        }
    }

    fun w(tag:String = "pxd",content:String = ""){
        if (!IS_RELEASE) {
            Log.w(tag,content)
        }
    }

}