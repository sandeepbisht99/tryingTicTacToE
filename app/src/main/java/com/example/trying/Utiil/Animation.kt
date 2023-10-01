package com.example.trying.Utiil

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * Created by sandeep on 10/1/2023.
 */
open class Animation(context: Context, attrs: AttributeSet?) : View(context, attrs) {

     val paint = Paint()
     var startX = 0f
     var startY = 0f
     var endX = 0f
     var endY = 0f


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        Log.d("anim1","msg")
        // Draw your Tic Tac Toe board here

        paint.color = Color.RED
        paint.strokeWidth = 10f

        canvas.drawLine(startX, startY, endX, endY, paint)
    }

    fun drawline(){
        Log.d("anim1","36")
        startX = 0f
        startY = 0f
        endX = width.toFloat()
        endY = height.toFloat()


        invalidate()
    }
}