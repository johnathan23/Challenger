package com.johnathan.challenger.movies

import android.os.Bundle
import android.util.Log
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
import com.johnathan.challenger.databinding.FragmentAllFilmsBinding
import com.johnathan.challenger.databinding.FragmentMoviesBinding
import com.johnathan.challenger.home.HomeViewModel
import com.johnathan.challenger.util.Constants
import com.johnathan.challenger.util.Util


class MoviesFragment : Fragment() {

    private lateinit var viewModel: MoviesViewModel
    private lateinit var adapter : FilmAdapter
    private lateinit var rvMovies : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        val binding = FragmentMoviesBinding.inflate(inflater, container, false)
        rvMovies = binding.rvMovies
        rvMovies.layoutManager = LinearLayoutManager(this@MoviesFragment.context)
        adapter = FilmAdapter(this.requireContext())
        rvMovies.adapter = adapter
        viewModel.moviesLiveData.observe(viewLifecycleOwner, {
            movies ->
            adapter.submitList(movies)
            Util.addLog("list of movies: $movies", null)
        })
        // Inflate the layout for this fragment
        return binding.root
    }
}