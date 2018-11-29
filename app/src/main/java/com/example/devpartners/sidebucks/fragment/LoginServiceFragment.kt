package com.example.devpartners.sidebucks.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.devpartners.sidebucks.R
import com.example.devpartners.sidebucks.enum.UserType
import com.example.devpartners.sidebucks.event.LoginAsEvent
import com.example.devpartners.sidebucks.event.RegisterEvent
import org.greenrobot.eventbus.EventBus


class LoginServiceFragment : Fragment() {
    var loginAs : TextView? = null
    var register : TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_login_service, container, false)
        setVariables(view)

        loginAs?.setOnClickListener {
            EventBus.getDefault().post(LoginAsEvent(UserType.CUSTOMER))
        }
        register?.setOnClickListener {
            EventBus.getDefault().post(RegisterEvent(UserType.SERVICE_PROVIDER))
        }
        return view
    }
    private fun setVariables(view : View) {
        loginAs = view.findViewById(R.id.loginAs)
        register = view.findViewById(R.id.register)
    }
}
