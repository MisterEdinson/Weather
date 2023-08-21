package com.example.weather.ui.home.adapter


import android.provider.Settings.System.getString
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.weather.R
import com.example.weather.data.web.model.yandex.HoursItem
import com.example.weather.databinding.ItemHourForecastsBinding
import com.example.weather.domain.utils.loadImage
import com.example.weather.ui.home.converters.TimeConvertedUnix

class HoursAdapter : RecyclerView.Adapter<HoursAdapter.HolderHour>() {

    private lateinit var binding: ItemHourForecastsBinding

    class HolderHour(binding: ItemHourForecastsBinding) : RecyclerView.ViewHolder(binding.root)

    val callback = object : DiffUtil.ItemCallback<HoursItem?>() {

        override fun areItemsTheSame(oldItem: HoursItem, newItem: HoursItem): Boolean {
            return oldItem.hourTs == newItem.hourTs
        }

        override fun areContentsTheSame(oldItem: HoursItem, newItem: HoursItem): Boolean {
            return oldItem.hourTs == newItem.hourTs
        }
    }

    val list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderHour {
        binding =
            ItemHourForecastsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HolderHour(binding)
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    override fun onBindViewHolder(holder: HolderHour, position: Int) {
        val item = list.currentList[position]
        val binding = ItemHourForecastsBinding.bind(holder.itemView)
        binding.apply {
            tvItemHour.text = TimeConvertedUnix().time(item?.hourTs ?: 1)
            imgItemCondition.loadImage("https://yastatic.net/weather/i/icons/funky/dark/${item?.icon}.svg")
            tvTempHour.text = "${item?.temp}\u00B0"
            tvPresHour.text = "${item?.pressureMm}"
        }
    }
}