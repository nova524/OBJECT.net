package com.objective.objectnet.view

import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class NeonCurveView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val path = Path()
        path.moveTo(700f, 0f) // 시작점 설정
        path.quadTo(300f, 569.25f, 500f, 1138.5f) // 곡선 설정 (제어점 좌표, 끝점 좌표)
        path.quadTo(700f, 1707.75f, 500f, 2277f)

        val paint = Paint()
        paint.color = 0xFFFFFFFF.toInt()
        paint.strokeWidth = 10f // 선의 두께 설정
        paint.style = Paint.Style.STROKE // 선 스타일 설정

        canvas.drawPath(path, paint) // 캔버스에 곡선 그리기

        val neonPaint = Paint().apply {
            isAntiAlias = true
            color = Color.WHITE // 네온 효과 색상 설정
            style = Paint.Style.STROKE
            strokeWidth = 10f // 네온 효과의 두께 설정
            maskFilter = BlurMaskFilter(20f, BlurMaskFilter.Blur.NORMAL) // 네온 효과를 위한 Blur 효과 설정
        }
        canvas?.drawPath(path, neonPaint)
    }
}