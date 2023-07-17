package com.example.loginproject.tool

import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.loginproject.R

fun Fragment.navigateTo(target: Fragment, addToStack:Boolean){
    parentFragmentManager.commit {
        setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_left,
            R.anim.pop_enter_from_left,
            R.anim.pop_exit_to_right
        )
        replace(R.id.fragmentContainerView, target)
        setReorderingAllowed(true)
        if (addToStack){ //是否入栈
            addToBackStack(null)
        }
    }
}