package com.johnathan.challenger.series

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.johnathan.challenger.R
import com.johnathan.challenger.adapter.FilmAdapter
import com.johnathan.challenger.api.dto.Film
import com.johnathan.challenger.databinding.FragmentMoviesBinding
import com.johnathan.challenger.databinding.FragmentSeriesBinding
import com.johnathan.challenger.movies.MoviesViewModel
import com.johnathan.challenger.util.Constants
import com.johnathan.challenger.util.Util

class SeriesFragment : Fragment() {

    private lateinit var viewModel: SeriesViewModel
    private lateinit var adapter : FilmAdapter
    private lateinit var rvSeries : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(SeriesViewModel::class.java)
        val binding = FragmentSeriesBinding.inflate(inflater, container, false)
        rvSeries = binding.rvSeries
        rvSeries.layoutManager = LinearLayoutManager(this@SeriesFragment.context)
        adapter = FilmAdapter(this.requireContext())
        rvSeries.adapter = adapter
        viewModel.seriesLiveData.observe(viewLifecycleOwner, {
                series ->
            adapter.submitList(series)
            Util.addLog("list of series: $series", null)
        })
        // Inflate the layout for this fragment
        return binding.root
    }
}