package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

class Practice04BitmapShaderView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(200f, 200f, 200f, paint)
    }

    init {
        //使用bitmap的像素作为图像或者文字的填充
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
        paint.shader = BitmapShader(bitmap, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
    }
}