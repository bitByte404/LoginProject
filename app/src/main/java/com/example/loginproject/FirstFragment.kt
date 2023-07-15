package com.example.loginproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup


class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_first, container, false)
        view.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN){
                parentFragmentManager.beginTransaction().apply {
                    setCustomAnimations(R.anim.enter,R.anim.exit)
                    replace(R.id.fragmentContainerView, SecondFragment())
                    setReorderingAllowed(true)
                    addSharedElement(view.findViewById(R.id.textView2),"redView")
                    commit()
                }
            }
            true }
        return view
    }

}