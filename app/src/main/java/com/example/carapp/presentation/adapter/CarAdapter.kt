package com.example.carapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carapp.R
import com.example.carapp.databinding.ItemCarBinding
import com.example.carapp.model.CarModel

class CarAdapter(
    private val carList: List<CarModel>,
    private val listener: Listener
) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter.ViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarAdapter.ViewHolder, position: Int) {
        holder.bind(carList[position],listener)

    }

    override fun getItemCount(): Int {
        return carList.size
    }

    inner class ViewHolder(private val binding: ItemCarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(carList: CarModel, listener: Listener) {
            binding.tvCarName.text = carList.name
            binding.tvYear.text = carList.year
            Glide.with(itemView.context)
                .load(carList.image)
                .into(binding.imgCar)
            itemView.setOnClickListener {
                listener.onClickItem(carList)
            }

        }
    }

    interface Listener {
        fun onClickItem(carList: CarModel)
    }
}