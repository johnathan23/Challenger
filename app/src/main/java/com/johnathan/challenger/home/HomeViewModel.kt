package com.johnathan.challenger.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnathan.challenger.FilmRepository
import com.johnathan.challenger.api.dto.Film
import com.johnathan.challenger.util.Constants
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private var _allMoviesList = MutableLiveData<MutableList<Film>>()
    private val homeRepository = FilmRepository()
    init {
        viewModelScope.launch {
            _allMoviesList.value = homeRepository.getAllMovies(Constants.ALL_MOVIES)
        }
    }
    val allMoviesLiveData: LiveData<MutableList<Film>> = _allMoviesList
}
