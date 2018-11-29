package com.example.devpartners.sidebucks.fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

import com.example.devpartners.sidebucks.R
import com.example.devpartners.sidebucks.enum.UserType
import com.example.devpartners.sidebucks.event.LoginAsEvent
import com.example.devpartners.sidebucks.event.ProviderNextEvent
import org.greenrobot.eventbus.EventBus


@SuppressLint("ValidFragment")
class RegisterProviderFragment(var activity: Activity) : Fragment() {
    var spinner : Spinner? = null
    var back : TextView? = null
    var nextButton : Button? = null
    var data : ArrayList<String> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_register_provider, container, false)
        setVariables(view)
        setData()
        var adapter = ArrayAdapter<String>(activity, R.layout.spinner_item, data)
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinner?.adapter = adapter

        back?.setOnClickListener {
            EventBus.getDefault().post(LoginAsEvent(UserType.SERVICE_PROVIDER))
        }

        nextButton?.setOnClickListener {
            EventBus.getDefault().post(ProviderNextEvent())
        }

        return view
    }

    private fun setVariables(view : View) {
        spinner = view.findViewById(R.id.spinnerService)
        back = view.findViewById(R.id.back)
        nextButton = view.findViewById(R.id.nextButton)
    }
    private fun setData() {
        data.add("Barber")
        data.add("Singer")
        data.add("Dancer")
        data.add("Teacher")
    }
}
