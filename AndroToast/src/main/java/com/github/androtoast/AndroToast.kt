package com.github.androtoast

import android.content.Context
import android.content.res.ColorStateList
import android.os.Build
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import coil.loadAny
import com.google.android.material.card.MaterialCardView


class AndroToast(private val context: Context) {

    init {
        baseToast = Toast.makeText(context, "", duration)
    }

//    todo add lottie
//    todo add option to set custom size for imageview
//    todo make enum classes

    companion object {
        const val SHORT = Toast.LENGTH_SHORT
        const val LONG = Toast.LENGTH_LONG
        var baseToast: Toast? = null
        var duration: Int = SHORT
        var layout: Int = R.layout.androtoast
        var tint: Int = R.color.offWhite
        var drawableLeft: Any? = null
        var drawableRight: Any? = null
        var drawableTop: Any? = null
        var drawableBottom: Any? = null
        var drawableLeftTint: Int? = null
        var drawableRightTint: Int? = null
        var drawableTopTint: Int? = null
        var drawableBottomTint: Int? = null
        var textColor: Int = R.color.black
        var text: String? = null
        var textSize: Float = 15f
        var gravity: Int? = null
        var xOffset: Int? = null
        var yOffset: Int? = null
        var elevation: Float? = null
        var typeface: Int? = null
        var cornerRadius: Float = 100f
        var shadowColor: Int? = null
        var strokeColor: Int? = null
        var strokeWidth: Int = 0
        var textAnimation: Int? = null
    }


    fun start() {
        val defGravity = Toast(context).gravity
        val defX = Toast(context).xOffset
        val defY = Toast(context).yOffset

        val Toasty = Toast.makeText(context, "", duration)

        val toastLayout: View =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(layout, null)
        toastLayout.background.setTint(ContextCompat.getColor(context, tint))

        val rootView = toastLayout.findViewById<MaterialCardView>(R.id.toast_root)
        elevation?.let {
            rootView?.cardElevation = it
        }
        rootView?.radius = cornerRadius
        rootView?.strokeWidth = strokeWidth

        strokeColor?.let {
            val colorInt: Int = context.resources.getColor(it)
            val csl = ColorStateList.valueOf(colorInt)
            rootView?.setStrokeColor(csl)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            shadowColor?.let {
                rootView?.setOutlineSpotShadowColor(ContextCompat.getColor(context, it))
            }
        }


        val iconLeft = toastLayout.findViewById<ImageView>(R.id.iv_icon_left)
        val iconRight = toastLayout.findViewById<ImageView>(R.id.iv_icon_right)
        val iconTop = toastLayout.findViewById<ImageView>(R.id.iv_icon_top)
        val iconBottom = toastLayout.findViewById<ImageView>(R.id.iv_icon_bottom)

        if (drawableLeft != null) {
            iconLeft.loadAny(drawableLeft)
            drawableLeftTint?.let { iconLeft.setColorFilter(ContextCompat.getColor(context, it)) }
            iconLeft.show()
        } else {
            iconLeft.hide()
        }
        if (drawableRight != null) {
            iconRight.loadAny(drawableRight)
            drawableRightTint?.let { iconRight.setColorFilter(ContextCompat.getColor(context, it)) }
            iconRight.show()
        } else {
            iconRight.hide()
        }
        if (drawableTop != null) {
            iconTop.loadAny(drawableTop)
            drawableTopTint?.let { iconTop.setColorFilter(ContextCompat.getColor(context, it)) }
            iconTop.show()
        } else {
            iconTop.hide()
        }
        if (drawableBottom != null) {
            iconBottom.loadAny(drawableBottom)
            drawableBottomTint?.let {
                println("here")
                iconBottom.setColorFilter(ContextCompat.getColor(context, it))
            }
            iconBottom.show()
        } else {
            iconBottom.hide()
        }

        val messageTextView = toastLayout.findViewById<TextView>(R.id.tv_message)
        messageTextView.setTextColor(ContextCompat.getColor(context, textColor))
        messageTextView.text = text
        messageTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)
        textAnimation?.let {
            messageTextView.startAnimation(AnimationUtils.loadAnimation(context, it))
        }
        if (typeface != null) {
            typeface?.let {
                val typeface = ResourcesCompat.getFont(context, it)
                messageTextView.typeface = typeface
            }
        } else {
            messageTextView.typeface = null
        }



        Toasty.view = toastLayout


        if (gravity == null && xOffset == null && yOffset == null) {
            Toasty.setGravity(defGravity, defX, defY)
        } else if (gravity == null && xOffset == null && yOffset != null) {
            Toasty.setGravity(defGravity, defX, yOffset!!)
        } else if (gravity == null && xOffset != null && yOffset == null) {
            Toasty.setGravity(defGravity, xOffset!!, defY)
        } else if (gravity == null && xOffset != null && yOffset != null) {
            Toasty.setGravity(defGravity, defX, yOffset!!)
        } else if (gravity != null && xOffset == null && yOffset == null) {
            Toasty.setGravity(gravity!!, defX, defY)
        } else if (gravity != null && xOffset == null && yOffset != null) {
            Toasty.setGravity(gravity!!, defX, yOffset!!)
        } else if (gravity != null && xOffset != null && yOffset == null) {
            Toasty.setGravity(gravity!!, xOffset!!, defY)
        } else if (gravity != null && xOffset != null && yOffset != null) {
            Toasty.setGravity(gravity!!, xOffset!!, yOffset!!)
        }


        Toasty.show()
    }
}