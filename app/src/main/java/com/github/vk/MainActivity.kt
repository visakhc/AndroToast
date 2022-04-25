/*
 * *
 *  * Created by visakhc on 25-04-2022
 *
 */

package com.github.vk

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.androtoast.AndroToast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btClick).setOnClickListener {

            AndroToast.apply {
                textColor = R.color.yellow
                text = "Hi I'm Testing"
                // textColor = R.color.white
                // textAnimation = R.anim.wobble

                // tint = R.color.red
                // gravity = Gravity.CENTER
                // strokeColor = R.color.green
                // strokeWidth = 4
                // elevation = 20f
                // shadowColor = R.color.red

                drawableLeft = R.drawable.ic_android_black_24dp
                // drawableRight = R.drawable.ic_android_black_24dp
                // drawableTop = R.drawable.ic_android_black_24dp
                // drawableBottom = R.drawable.ic_android_black_24dp

                // drawableLeftTint = R.color.green
                // drawableRightTint = R.color.yellow
                // drawableTopTint = R.color.white
                // drawableBottomTint = R.color.black

            }.start(this)

        }
    }
}