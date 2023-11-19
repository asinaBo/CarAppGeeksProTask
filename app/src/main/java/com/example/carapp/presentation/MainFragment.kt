package com.example.carapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.carapp.R
import com.example.carapp.databinding.FragmentMainBinding
import com.example.carapp.model.CarModel
import com.example.carapp.presentation.adapter.CarAdapter


class MainFragment : Fragment(), CarAdapter.Listener {
    lateinit var binding: FragmentMainBinding

    val data = listOf(
        CarModel(

            name = "Camry 1",
            year = "2010",
            image = "https://img.freepik.com/free-vector/white-convertible-car-isolated-on-white-vector_53876-66815.jpg",

            ),
        CarModel(

            name = "Audi ",
            year = "2017",
            image = "https://cdn.dribbble.com/userupload/10460030/file/original-cdddf2c402dd52e629eeedf733397793.jpg?crop=0x0-1961x1471&resize=400x300&vertical=center",

            ),
        CarModel(

            name = "Mercedes",
            year = "2019",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTZTnW0Sx4Ino5l_gTVnPpxoZZa74qqxGDVA&usqp=CAU",

            ),
    )
    val adapter = CarAdapter(data, this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcView.adapter = adapter

    }

    override fun onClickItem(carList: CarModel) {
        val bundle = Bundle()
        bundle.putSerializable("car", carList)
        findNavController().navigate(R.id.detailFragment,bundle)

    }

}


