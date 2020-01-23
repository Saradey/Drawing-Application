package com.evgeny.goncharov.applicationdrawcanvas

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var smallBrush: Int? = 0
    private var mediumBrush: Int? = 0
    private var largeBrush: Int? = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBrushLarge()
        initChooseColor()
        initDialogChooseLargePaint()
        initEraser()
        initNewBackground()
        initSaveBackground()
    }


    private fun initSaveBackground() {
        imvSave.setOnClickListener {
            
        }
    }


    private fun initNewBackground() {
        imvDoc.setOnClickListener {
            canvasDrawable.startNew()
        }
    }


    private fun initEraser() {
        imvEraser.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setTitle("Erase Size")
            dialog.setContentView(R.layout.dialog_choose_brush_size)

            dialog.findViewById<ImageButton>(R.id.small_brush).setOnClickListener {
                canvasDrawable.setErase(true)
                canvasDrawable.setBrushSize(smallBrush?.toFloat())
                dialog.dismiss()
            }

            dialog.findViewById<ImageButton>(R.id.medium_brush).setOnClickListener {
                canvasDrawable.setErase(true)
                canvasDrawable.setBrushSize(mediumBrush?.toFloat())
                dialog.dismiss()
            }

            dialog.findViewById<ImageButton>(R.id.large_brush).setOnClickListener {
                canvasDrawable.setErase(true)
                canvasDrawable.setBrushSize(largeBrush?.toFloat())
                dialog.dismiss()
            }
            dialog.show()
        }
    }


    private fun initDialogChooseLargePaint() {
        imvPaint.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setTitle("Brush Size")
            dialog.setContentView(R.layout.dialog_choose_brush_size)

            dialog.findViewById<ImageButton>(R.id.small_brush).setOnClickListener {
                canvasDrawable.setBrushSize(smallBrush?.toFloat())
                canvasDrawable.setErase(false)
                dialog.dismiss()
            }

            dialog.findViewById<ImageButton>(R.id.medium_brush).setOnClickListener {
                canvasDrawable.setBrushSize(mediumBrush?.toFloat())
                canvasDrawable.setErase(false)
                dialog.dismiss()
            }

            dialog.findViewById<ImageButton>(R.id.large_brush).setOnClickListener {
                canvasDrawable.setBrushSize(largeBrush?.toFloat())
                canvasDrawable.setErase(false)
                dialog.dismiss()
            }
            dialog.show()
        }
    }


    private fun initBrushLarge() {
        smallBrush = resources?.getInteger(R.integer.small_size)
        mediumBrush = resources?.getInteger(R.integer.medium_size)
        largeBrush = resources?.getInteger(R.integer.large_size)
    }


    private fun initChooseColor() {
        imbRedRed.setOnClickListener {
            canvasDrawable.setNewColor(imbRedRed.tag.toString())
            canvasDrawable.setErase(false)
        }
        imbRed.setOnClickListener {
            canvasDrawable.setNewColor(imbRed.tag.toString())
            canvasDrawable.setErase(false)
        }
        imbOrange.setOnClickListener {
            canvasDrawable.setNewColor(imbOrange.tag.toString())
            canvasDrawable.setErase(false)
        }
        imbYellow.setOnClickListener {
            canvasDrawable.setNewColor(imbYellow.tag.toString())
            canvasDrawable.setErase(false)
        }
        imbGreenGreen.setOnClickListener {
            canvasDrawable.setNewColor(imbGreenGreen.tag.toString())
            canvasDrawable.setErase(false)
        }
        imbGreen.setOnClickListener {
            canvasDrawable.setNewColor(imbGreen.tag.toString())
            canvasDrawable.setErase(false)
        }
        imbBlue.setOnClickListener {
            canvasDrawable.setNewColor(imbBlue.tag.toString())
            canvasDrawable.setErase(false)
        }
        imbNoNameColor.setOnClickListener {
            canvasDrawable.setNewColor(imbNoNameColor.tag.toString())
            canvasDrawable.setErase(false)
        }
        imbOrangeOrange.setOnClickListener {
            canvasDrawable.setNewColor(imbOrangeOrange.tag.toString())
            canvasDrawable.setErase(false)
        }
        imbWhite.setOnClickListener {
            canvasDrawable.setNewColor(imbWhite.tag.toString())
            canvasDrawable.setErase(false)
        }
        imbGray.setOnClickListener {
            canvasDrawable.setNewColor(imbGray.tag.toString())
            canvasDrawable.setErase(false)
        }
        imbBlack.setOnClickListener {
            canvasDrawable.setNewColor(imbBlack.tag.toString())
            canvasDrawable.setErase(false)
        }
    }


}
