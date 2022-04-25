package com.github.vk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.Gravity
import android.widget.Button
import com.github.androtoast.AndroToast
import com.github.androtoast.AndroToast.Companion.drawableBottom
import com.github.androtoast.AndroToast.Companion.drawableBottomTint
import com.github.androtoast.AndroToast.Companion.drawableLeft
import com.github.androtoast.AndroToast.Companion.drawableLeftTint
import com.github.androtoast.AndroToast.Companion.drawableRight
import com.github.androtoast.AndroToast.Companion.drawableRightTint
import com.github.androtoast.AndroToast.Companion.drawableTop
import com.github.androtoast.AndroToast.Companion.drawableTopTint
import com.github.androtoast.AndroToast.Companion.elevation
import com.github.androtoast.AndroToast.Companion.gravity
import com.github.androtoast.AndroToast.Companion.shadowColor
import com.github.androtoast.AndroToast.Companion.strokeColor
import com.github.androtoast.AndroToast.Companion.strokeWidth
import com.github.androtoast.AndroToast.Companion.text
import com.github.androtoast.AndroToast.Companion.textAnimation
import com.github.androtoast.AndroToast.Companion.textColor
import com.github.androtoast.AndroToast.Companion.tint

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btClick).setOnClickListener {
            AndroToast(this@MainActivity).apply {
                text = "Hi I'm Testing"
//                textColor = R.color.white
//                textAnimation = R.anim.wobble

//                tint = R.color.red
//                gravity = Gravity.CENTER
//                strokeColor = R.color.green
//                strokeWidth = 4
//                elevation = 20f
//                shadowColor = R.color.red

                drawableLeft = R.drawable.ic_android_black_24dp
//                drawableRight = R.drawable.ic_android_black_24dp
//                drawableTop = R.drawable.ic_android_black_24dp
//                drawableBottom = R.drawable.ic_android_black_24dp

//                drawableLeftTint = R.color.green
//                drawableRightTint = R.color.yellow
//                drawableTopTint = R.color.white
//                drawableBottomTint = R.color.black

            }.start()
        }
    }
}