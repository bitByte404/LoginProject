package com.example.loginproject.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.loginproject.R
import com.example.loginproject.databinding.FragmentPatternLoginBinding
import com.example.loginproject.databinding.FragmentPinLoginBinding
import com.example.loginproject.tool.navigateTo


class PinLoginFragment : Fragment() {
    private lateinit var binding: FragmentPinLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPinLoginBinding.inflate(inflater, null, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nameInputView.setTitle("用户名")
        binding.nameInputView.setPlaceholder("请输入用户名")
        binding.passwordInputView.apply {
            setTitle("密码")
            setPlaceholder("请输入密码")
        }
    }
}