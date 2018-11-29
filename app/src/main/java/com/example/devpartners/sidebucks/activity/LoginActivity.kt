package com.example.devpartners.sidebucks.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.devpartners.sidebucks.R
import com.example.devpartners.sidebucks.fragment.OptionLoginFragment
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        customerButton.setOnClickListener {
            nextActivity("customer")
        }
        spButton.setOnClickListener {
            nextActivity("service_provider")
        }

    }

    private fun nextActivity(data : String) {
        var intent = Intent(this, Login2Activity::class.java)
        intent.putExtra("data",data)
        startActivity(intent)
        finish()
    }
}
