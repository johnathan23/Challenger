package com.johnathan.challenger.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnathan.challenger.FilmRepository
import com.johnathan.challenger.api.dto.Film
import com.johnathan.challenger.util.Constants
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {
    private var _moviesList = MutableLiveData<MutableList<Film>>()
    private val homeRepository = FilmRepository()
    init {
        viewModelScope.launch {
            _moviesList.value = homeRepository.getAllMovies(Constants.MOVIE)
        }
    }
    val moviesLiveData: LiveData<MutableList<Film>> = _moviesList
}