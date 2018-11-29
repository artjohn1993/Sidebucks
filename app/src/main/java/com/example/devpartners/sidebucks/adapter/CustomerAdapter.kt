package com.example.devpartners.sidebucks.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.devpartners.sidebucks.R

class CustomerAdapter() : RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomerViewHolder {
        val inflater = LayoutInflater.from(p0?.context)
        val layout = inflater.inflate(R.layout.layout_customer_dashboard, p0, false)
        return CustomerViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(p0: CustomerViewHolder, p1: Int) {

    }

    class CustomerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }
}