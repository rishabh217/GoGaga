package com.rishabhgupta.gogaga.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.ScaleAnimation
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import com.appyvet.materialrangebar.RangeBar
import com.appyvet.materialrangebar.RangeBar.OnRangeBarChangeListener
import com.rishabhgupta.gogaga.R
import kotlinx.android.synthetic.main.fragment_match.*


class MatchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_match, container, false)

        val scaleAnimation = ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        scaleAnimation.duration = 500
        val bounceInterpolator = BounceInterpolator()
        scaleAnimation.interpolator = bounceInterpolator

        val mButton: ToggleButton? = view?.findViewById(R.id.men)
        val wButton: ToggleButton? = view?.findViewById(R.id.women)
        val arrayMen = arrayListOf<Int>(R.drawable.ic_men_young, R.drawable.ic_men, R.drawable.ic_men_old)
        val arrayWomen = arrayListOf<Int>(R.drawable.ic_women_young, R.drawable.ic_women, R.drawable.ic_women_old)
        var arraySelected = arrayMen
        val rangeBar: RangeBar? = view?.findViewById(R.id.ageRangeBar)
        val start: TextView? = view?.findViewById(R.id.start)
        val end: TextView? = view?.findViewById(R.id.end)

        mButton?.setOnCheckedChangeListener(object:View.OnClickListener, CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                p0?.startAnimation(scaleAnimation)
                if(!mButton.isChecked && !wButton!!.isChecked) {
                    wButton.isChecked = true
                }
                if(!mButton.isChecked) {
                    arraySelected = arrayWomen
                }
                image_gender?.setImageResource(arraySelected[0])
            }

            override fun onClick(p0: View?) {
            }
        })
        wButton?.setOnCheckedChangeListener(object:View.OnClickListener, CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                p0?.startAnimation(scaleAnimation)
                if(!mButton!!.isChecked && !wButton.isChecked) {
                    mButton.isChecked = true
                }
                else arraySelected = arrayWomen
                if(!wButton.isChecked) {
                    arraySelected = arrayMen
                }
                image_gender?.setImageResource(arraySelected[0])
            }

            override fun onClick(p0: View?) {
            }
        })

        rangeBar?.setOnRangeBarChangeListener(object : OnRangeBarChangeListener {
            override fun onTouchEnded(rangeBar: RangeBar?) {
            }

            override fun onRangeChangeListener(
                rangeBar: RangeBar, leftPinIndex: Int,
                rightPinIndex: Int,
                leftPinValue: String, rightPinValue: String
            ) {
                if (leftPinValue > "18" && rightPinValue < "25" || rightPinValue > "18" && leftPinValue < "25") {
                    image_gender?.setImageResource(arraySelected[0])
                }
                if (leftPinValue > "25" && rightPinValue < "48" || rightPinValue > "25" && leftPinValue < "48") {
                    image_gender?.setImageResource(arraySelected[1])
                }
                else if (leftPinValue > "48" && rightPinValue < "70" || rightPinValue > "48" && leftPinValue < "70") {
                    image_gender?.setImageResource(arraySelected[2])
                }
                start?.text = leftPinValue
                end?.text = rightPinValue
            }

            override fun onTouchStarted(rangeBar: RangeBar?) {
            }
        })

        return view

    }
}
