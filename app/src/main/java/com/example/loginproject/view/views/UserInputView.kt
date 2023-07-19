package com.example.loginproject.view.views

import android.content.Context
import android.service.quicksettings.Tile
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import com.example.loginproject.R
import com.example.loginproject.databinding.LayoutUserInputBinding

/**
/** 使用代码创建一个控件时，调用这个构造方法 */
constructor(context: Context) : super(context) {}
/** 在xml中添加一个控件 并设置对应属性 就调用这个构造方法 */
constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}
/** 在xml中添加了一个控件 并且设置了style样式的，就会调用这个构造方法 */
constructor(context: Context, attrs: AttributeSet?, style: Int) : super( context, attrs, style ) {}
 */
class UserInputView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
//    private var titleTextView: TextView
//    private var inputEditView: EditText
    private val binding: LayoutUserInputBinding by lazy {
        LayoutUserInputBinding.inflate(LayoutInflater.from(context))
}

    init {//当一个对象被创建  1.构造函数 2.init方法
        //将xml中layout布局文件和当前这个类相关联
        //使用布局解析器
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.layout_user_input, null, false)
        //创建一个布局参数
        val lp = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
            )
        //将解析出来的View添加到当前的容器里面 显示出来
        addView(view, lp)

        //获取对应的控件
//        titleTextView = view.findViewById(R.id.titleTextView)
//        inputEditView = view.findViewById(R.id.inputEditText)

    }

    fun setTitle(title: String) {
        binding.titleTextView.text = title
    }

    fun setPlaceholder(text: String) {
        binding.inputEditText.hint = text
    }

}