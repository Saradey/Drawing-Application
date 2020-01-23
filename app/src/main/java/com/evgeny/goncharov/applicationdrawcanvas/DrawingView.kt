package com.evgeny.goncharov.applicationdrawcanvas

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View

class DrawingView(context: Context, attrs: AttributeSet) :
    View(context, attrs) {

    private lateinit var drawPath: Path
    private lateinit var drawPaint: Paint
    private lateinit var canvasPaint: Paint
    private var paintColor = 0xFF660000
    private lateinit var drawCanvas: Canvas
    private lateinit var canvasBitmap: Bitmap
    private var brushSize: Float? = 0f
    private var lastBrushSize: Float? = 0f
    private var erase = false

    init {
        setupDrawing()
    }


    private fun setupDrawing() {
        drawPath = Path()
        drawPaint = Paint()
        drawPaint.color = paintColor.toInt()
        drawPaint.isAntiAlias = true
        drawPaint.style = Paint.Style.STROKE
        drawPaint.strokeJoin = Paint.Join.ROUND
        drawPaint.strokeCap = Paint.Cap.ROUND
        canvasPaint = Paint(Paint.DITHER_FLAG)
        brushSize = resources?.getInteger(R.integer.medium_size)?.toFloat()
        drawPaint.strokeWidth = brushSize!!
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        drawCanvas = Canvas(canvasBitmap)
    }


    override fun onDraw(canvas: Canvas?) {
        canvas?.drawBitmap(canvasBitmap, 0f, 0f, canvasPaint)
        canvas?.drawPath(drawPath, drawPaint)
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            val touchX = event.x
            val touchY = event.y

            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    drawPath.moveTo(touchX, touchY)
                    drawPath.lineTo(touchX, touchY)
                    drawCanvas.drawPath(drawPath, drawPaint)
                }
                MotionEvent.ACTION_MOVE -> {
                    drawPath.lineTo(touchX, touchY)
                    drawCanvas.drawPath(drawPath, drawPaint)
                }
                MotionEvent.ACTION_UP -> {
                    drawCanvas.drawPath(drawPath, drawPaint)
                    drawPath.reset()
                }
            }
        } ?: kotlin.run {
            return false
        }
        invalidate()
        return true
    }


    fun setNewColor(color: String) {
        invalidate()
        paintColor = Color.parseColor(color).toLong()
        drawPaint.color = paintColor.toInt()
    }


    fun setBrushSize(newSize: Float?) {
        val newPixelAmount = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            newSize!!,
            resources.displayMetrics
        )
        brushSize = newPixelAmount
        drawPaint.strokeWidth = brushSize!!
    }


    fun setErase(erase: Boolean) {
        this.erase = erase

        if (this.erase) {
            drawPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        } else {
            drawPaint.xfermode = null
        }
    }


    fun startNew() {
        drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate()
    }
}