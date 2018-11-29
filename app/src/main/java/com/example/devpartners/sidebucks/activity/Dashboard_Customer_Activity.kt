package com.example.devpartners.sidebucks.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.example.devpartners.sidebucks.adapter.CustomerAdapter
import com.example.devpartners.sidebucks.R
import com.example.devpartners.sidebucks.adapter.CategoryAdapter
import kotlinx.android.synthetic.main.activity_dashboard__customer_.*
import kotlinx.android.synthetic.main.toolbar_customer.*


class Dashboard_Customer_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard__customer_)
        var toggle = ActionBarDrawerToggle(this, drawer_layout, R.string.drawer_open , R.string.drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        setRecycler()
        filterGroup.visibility = View.GONE
        closeFilter.visibility = View.GONE
        moreNav.setOnClickListener {
            drawer_layout.openDrawer(Gravity.END)
        }
        closeNav.setOnClickListener {
            unactiveSearch()
        }
        searchNav.setOnClickListener {
            activeSearch()
            //drawer_layout.openDrawer(Gravity.START)
        }
        closeFilter.setOnClickListener {
            filterGroup.visibility = View.GONE
            closeFilter.visibility = View.GONE
        }
        openFilter.setOnClickListener {
            filterGroup.visibility = View.VISIBLE
            closeFilter.visibility = View.VISIBLE
            closeFilter.text = "close"
        }
        categorySpinner.adapter = CategoryAdapter(this)

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(Gravity.END)) {
            drawer_layout.closeDrawer(Gravity.END)
        }
        else {
            super.onBackPressed()
        }
    }

    private fun setRecycler() {
        customerRecycler.layoutManager = LinearLayoutManager(this,
                LinearLayout.VERTICAL,
                false)
        customerRecycler.adapter = CustomerAdapter()
    }
    private fun activeSearch() {
        toolbar_logo.visibility = View.GONE
        notificationNav.visibility = View.GONE
        moreNav.visibility = View.GONE
        closeNav.visibility = View.VISIBLE
        searchBoxNav.visibility = View.VISIBLE
    }
    private fun unactiveSearch() {
        toolbar_logo.visibility = View.VISIBLE
        notificationNav.visibility = View.VISIBLE
        moreNav.visibility = View.VISIBLE
        closeNav.visibility = View.GONE
        searchBoxNav.visibility = View.GONE
    }
}
