package com.example.devpartners.sidebucks.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.example.devpartners.sidebucks.R

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class CategoryAdapter(var context : Context) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?) : View {
        var view = convertView
        var holder : CategoryAdapter.ViewHolder
        var item = getItemViewType(position)

        if (convertView == null) {
            var layoutInflator = LayoutInflater.from(context)
            view = layoutInflator.inflate(R.layout.layout_category_spinner, parent, false)

            holder = ViewHolder()
            holder.mCheckBox = view.findViewById(R.id.checkbox)
            holder.mTextView = view.findViewById(R.id.text)
            view.tag = holder
        }
        else {
            holder = view?.tag as ViewHolder
        }
        if(position == 0) {
            holder.mTextView.text = "filter a category"
            holder.mCheckBox.visibility = View.GONE
        }
        else {

        }
        return view!!
    }


    override fun getItemViewType(position: Int): Int {
        return if (position === 0) 0 else viewTypeCount -1
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
       return 10 + 1
    }

    class ViewHolder {
        lateinit var mTextView : TextView
        lateinit var mCheckBox : CheckBox
    }
}