package com.rishabhgupta.gogaga.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.fragment.app.Fragment
import com.rishabhgupta.gogaga.R
import kotlinx.android.synthetic.main.fragment_app.*


class AppFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_app, container, false)

        val switch1: Switch? = view?.findViewById(R.id.switch_alert)
        val switch2: Switch? = view?.findViewById(R.id.switch_only)

        switch1?.isChecked = true
        switch1?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                selector1?.setCardBackgroundColor(resources.getColor(R.color.white))
            } else {
                selector1?.setCardBackgroundColor(resources.getColor(R.color.colorLight))
            }
        }

        switch2?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                selector2?.setCardBackgroundColor(resources.getColor(R.color.white))
            } else {
                selector2?.setCardBackgroundColor(resources.getColor(R.color.colorLight))
            }
        }

        return view
    }
}
