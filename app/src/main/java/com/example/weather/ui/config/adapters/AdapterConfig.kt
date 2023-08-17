package com.example.weather.ui.config.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.weather.R

class AdapterConfig(
    private val context: Context?,
    private val configData: Array<String>
) : BaseAdapter() {

    override fun getCount(): Int {
        return configData.size
    }
    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.spiner_config, p2, false)
        val element = view.findViewById<TextView>(R.id.tvItemText)
        element.text = configData[p0]
        return view
    }
}