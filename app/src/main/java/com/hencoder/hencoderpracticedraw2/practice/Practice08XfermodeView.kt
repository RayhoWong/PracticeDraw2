package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

class Practice08XfermodeView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap1: Bitmap? = null
    var bitmap2: Bitmap? = null
    val xferMode1 = PorterDuffXfermode(PorterDuff.Mode.SRC)
    val xferMode2 = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    val xferMode3 = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 使用 paint.setXfermode() 设置不同的结合绘制效果
        // 别忘了用 canvas.saveLayer() 开启 off-screen buffer
        val safed = canvas.saveLayer(null,null,Canvas.ALL_SAVE_FLAG)

        canvas.drawBitmap(bitmap1, 0f, 0f, paint)
        // 第一个：PorterDuff.Mode.SRC
        paint.xfermode = xferMode1
        canvas.drawBitmap(bitmap2, 0f, 0f, paint)
        paint.xfermode = null
        canvas.drawBitmap(bitmap1, bitmap1!!.width + 100.toFloat(), 0f, paint)
        // 第二个：PorterDuff.Mode.DST_IN
        paint.xfermode = xferMode2
        canvas.drawBitmap(bitmap2, bitmap1!!.width + 100.toFloat(), 0f, paint)
        paint.xfermode = null
        canvas.drawBitmap(bitmap1, 0f, bitmap1!!.height + 20.toFloat(), paint)
        // 第三个：PorterDuff.Mode.DST_OUT
        paint.xfermode = xferMode3
        canvas.drawBitmap(bitmap2, 0f, bitmap1!!.height + 20.toFloat(), paint)
        // 用完之后使用 canvas.restore() 恢复 off-screen buffer
        paint.xfermode = null
        canvas.restoreToCount(safed)
    }

    init {
        bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman) //目标图像
        bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo) //源图像
    }
}