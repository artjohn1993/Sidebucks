package com.example.devpartners.sidebucks.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.devpartners.sidebucks.R
import com.example.devpartners.sidebucks.enum.UserType
import com.example.devpartners.sidebucks.event.*
import com.example.devpartners.sidebucks.fragment.LoginCustomerFragment
import com.example.devpartners.sidebucks.fragment.LoginServiceFragment
import com.example.devpartners.sidebucks.fragment.RegisterCustomerFragment
import com.example.devpartners.sidebucks.fragment.RegisterProviderFragment
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.startActivity

class Login2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        checkIntent()
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onLoginAsEvent(event : LoginAsEvent) {
       if (event.type == UserType.CUSTOMER) {
           changeFragment(LoginCustomerFragment())
       } else {
           changeFragment(LoginServiceFragment())
       }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onRegisterEvent(event : RegisterEvent) {
        if (event.type == UserType.CUSTOMER) {
            changeFragment(RegisterCustomerFragment())
        } else {
            changeFragment(RegisterProviderFragment(this))
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onSIgnInEvent(event : SIgnInEvent) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onCreateAccountEvent(event : CreateAccountEvent) {
        startActivity<Dashboard_Customer_Activity>()
        finish()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onProviderNextEvent(event : ProviderNextEvent) {
        startActivity<ProviderIdFormActivity>()
    }

    private fun checkIntent() {
        if (intent.extras != null) {
            var data = intent.getStringExtra("data")
            if (data == "customer") {
                changeFragment(LoginCustomerFragment())
            }
            else {
                changeFragment(LoginServiceFragment())
            }
        }
    }
    private fun changeFragment(data : android.support.v4.app.Fragment) {
        var fragment = supportFragmentManager.beginTransaction()
        fragment.setCustomAnimations(R.anim.abc_slide_in_bottom, android.R.animator.fade_out)
        fragment.replace(R.id.login2Frame, data).commit()
    }

}
