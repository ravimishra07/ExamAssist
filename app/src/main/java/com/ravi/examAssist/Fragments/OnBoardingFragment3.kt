package com.ravi.examAssist.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.ravi.examAssist.Activity.LoginActivity
import com.ravi.examAssist.MainActivity
import com.ravi.examAssist.R

class OnBoardingFragment3 : Fragment() {

    private var move_to_MainActivityLayout: LinearLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_on_boarding3, container, false)

        move_to_MainActivityLayout = view.findViewById(R.id.move_to_MainActivityLayout)


        move_to_MainActivityLayout!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        })


        return view;
    }


}