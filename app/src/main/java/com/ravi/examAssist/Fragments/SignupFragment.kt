package com.ravi.examAssist.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.ravi.examAssist.R

class SignupFragment : Fragment() {

    var ed_name: EditText ? = null
    var ed_email: EditText ? = null
    var ed_password: EditText ? = null
    var ed_confPassword: EditText ? = null
    var txt_SignUp: TextView ? = null
    var v = 0f

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_signup, container, false)

        ed_name = view.findViewById(R.id.ed_name)
        ed_email = view.findViewById(R.id.ed_email)
        ed_password = view.findViewById(R.id.ed_password)
        ed_confPassword = view.findViewById(R.id.ed_confPassword)
        txt_SignUp = view.findViewById(R.id.txt_SignUp)

//        ed_name!!.setTranslationY(800f)
//        ed_email!!.setTranslationY(800f)
//        ed_password!!.setTranslationY(800f)
//        ed_confPassword!!.setTranslationY(800f)
//        txt_SignUp!!.setTranslationY(800f)
//
//        ed_name!!.setAlpha(v)
//        ed_email!!.setAlpha(v)
//        ed_password!!.setAlpha(v)
//        ed_confPassword!!.setAlpha(v)
//        txt_SignUp!!.setAlpha(v)
//
//
//        ed_name!!.animate().translationX(0f).alpha(1f).setDuration(1000).setStartDelay(300).start()
//        ed_email!!.animate().translationX(0f).alpha(1f).setDuration(1000).setStartDelay(500).start()
//        ed_password!!.animate().translationX(0f).alpha(1f).setDuration(1000).setStartDelay(700).start()
//        ed_confPassword!!.animate().translationX(0f).alpha(1f).setDuration(1000).setStartDelay(800).start()
//        txt_SignUp!!.animate().translationX(0f).alpha(1f).setDuration(1000).setStartDelay(800).start()



        return  view;
    }
}