package com.example.loginproject.tool

import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.loginproject.R

fun Fragment.navigateTo(
    target: Fragment,
    enterAnim: Int = R.anim.enter_from_right,
    exitAnim: Int = R.anim.exit_to_left,
    popEnter:Int = R.anim.pop_enter_from_left,
    popExit: Int = R.anim.pop_exit_to_right,
    addToStack:Boolean=true
){
    parentFragmentManager.commit {
        setCustomAnimations(enterAnim,exitAnim,popEnter,popExit )
        replace(R.id.fragmentContainerView, target)
        setReorderingAllowed(true)
        if (addToStack){ //是否入栈
            addToBackStack(null)
        }
    }
}