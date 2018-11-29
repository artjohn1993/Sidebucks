package com.example.devpartners.sidebucks.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.example.devpartners.sidebucks.R
import com.example.devpartners.sidebucks.enum.UserType
import com.example.devpartners.sidebucks.event.CreateAccountEvent
import com.example.devpartners.sidebucks.event.LoginAsEvent
import org.greenrobot.eventbus.EventBus


class RegisterCustomerFragment : Fragment() {
    var back : TextView? = null
    var createAccount : Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
       var view = inflater.inflate(R.layout.fragment_register_customer, container, false)
        setVariables(view)
        back?.setOnClickListener {
            EventBus.getDefault().post(LoginAsEvent(UserType.CUSTOMER))
        }
        createAccount?.setOnClickListener {
            EventBus.getDefault().post(CreateAccountEvent())
        }
        return view
    }

    private fun setVariables(view : View) {
        back = view.findViewById(R.id.back)
        createAccount = view.findViewById(R.id.createAccount)
    }
}
