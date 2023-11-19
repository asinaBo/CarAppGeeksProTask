package com.example.carapp.presentation

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.carapp.databinding.FragmentDetailBinding
import com.example.carapp.model.CarModel

class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() {
        val result = arguments?.getSerializable("car") as CarModel?

        result?.let {
            binding.tvCarDetail.text = it.name
            binding.tvCarYear.text = it.year

            Glide.with(requireContext())
                .load(it.image)
                .into(binding.imgCarDetail)
        }
    }

}