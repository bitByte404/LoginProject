package com.example.loginproject.user

import android.content.Context
import android.util.Log
import com.example.loginproject.file.FileManager
import com.example.loginproject.tool.MyLog
import java.lang.ref.WeakReference

class UserManager private constructor(private val context: WeakReference<Context>){
    private val users = arrayListOf<User>() //保存所有用户对象
    private val fileManager = FileManager.sharedInstance()
    companion object{
        private var instance:UserManager? = null
        fun sharedInstance(context: Context):UserManager{
            if (instance == null){
                synchronized(this){
                    if (instance == null){
                        instance  = UserManager(WeakReference(context))
                    }
                }
            }
            return instance!!
        }
    }

    /**
     * 加载所有用户信息
     */
    fun loadAllUserInfo(){
        fileManager.readData(context.get()!!).also {
            users.addAll(it)
            MyLog.v("$users")
        }
    }

    /**
     * 是否有用户
     */
    fun hasUser() = users.size > 0

    /**
     * 用户名是否存在
     */
    fun checkUser(name:String):Boolean{
        users.forEach {
            if (it.name == name){
                return true
            }
        }
        return false
    }

    /**
     *用户名和密码是否正确
     */
    fun checkUser(name: String, password:String, type:Int):Boolean{
        users.forEach { user ->
            if (user.name == name){ //找用户
                return if (type == PasswordType.LoginType_Pin){
                    user.pin == password //比较pin密码是否相同
                }else{
                    user.pattern == password //比较图案密码是否相同
                }
            }
        }
        return false
    }

    /**
     * 获取当前登录用户
     */
    fun currentUser():User?{
        users.filter { it.isLogin }.also {
            return if (it.isNotEmpty()){
                it[0] //同一时间只有一个登录用户
            }else{
                null
            }
        }
    }

    /**
     * 保存注册用户信息
     */
    fun registUser(name: String,pin:String,pattern: String){
        //将注册的用户添加到用户信息中
        users.add(User(name,pin,pattern,false ))
    }

    /**
     * 登录
     */
    fun login(name: String, password: String, type: Int):Boolean{
        var user:User? = null
        users.forEach {
            if (it.name == name){
                if (type == PasswordType.LoginType_Pin){
                    if (it.pin == password){
                        user = it
                    }
                }else{
                    if (it.pattern == password){
                        user = it
                    }
                }
            }
        }
        return if (user != null){
            currentUser()?.let { it.isLogin = false } //将之前的登录状态改回false
            user?.isLogin = true   //将当前登录用户状态改为true
            fileManager.writeData(context.get()!!,users)//将所有用信息重新写入文件
            true
        }else{
            false
        }
    }
}