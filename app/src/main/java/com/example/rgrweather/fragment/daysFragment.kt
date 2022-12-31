package com.example.rgrweather.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rgrweather.MainViewModel
import com.example.rgrweather.R
import com.example.rgrweather.adapters.WeatherAdapter
import com.example.rgrweather.adapters.WeatherModel
import com.example.rgrweather.databinding.FragmentDaysBinding


class daysFragment : Fragment(), WeatherAdapter.Listener {
    private lateinit var adapter: WeatherAdapter
    private lateinit var binding: FragmentDaysBinding
    private val model: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        model.liveDataList.observe(viewLifecycleOwner){
            adapter.submitList(it.subList(0, it.size))
        }
    }
    private fun init() = with(binding){
        adapter = WeatherAdapter(this@daysFragment)
        rcView.layoutManager = LinearLayoutManager(activity)
        rcView.adapter = adapter
    }
    companion object {

        @JvmStatic
        fun newInstance() = daysFragment()

    }

    override fun onClick(item: WeatherModel) {
        model.liveDataCurrent.value = item
    }
}