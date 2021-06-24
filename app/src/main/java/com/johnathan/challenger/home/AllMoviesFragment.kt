package com.johnathan.challenger.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.johnathan.challenger.R
import com.johnathan.challenger.adapter.FilmAdapter
import com.johnathan.challenger.api.dto.Film
import com.johnathan.challenger.databinding.FragmentAllFilmsBinding
import com.johnathan.challenger.util.Constants
import com.johnathan.challenger.util.Util

class AllMoviesFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter : FilmAdapter
    private lateinit var rvAllMovies : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val binding = FragmentAllFilmsBinding.inflate(inflater, container, false)
        rvAllMovies = binding.rvAllFilm
        rvAllMovies.layoutManager = LinearLayoutManager(this@AllMoviesFragment.context)
        adapter = FilmAdapter(this.requireContext())
        rvAllMovies.adapter = adapter
        viewModel.allMoviesLiveData.observe(viewLifecycleOwner, {
            allMoviesList ->
            adapter.submitList(allMoviesList)
            Util.addLog("list of all movies: $allMoviesList", null)
        })
        // Inflate the layout for this fragment
        return binding.root
    }
}