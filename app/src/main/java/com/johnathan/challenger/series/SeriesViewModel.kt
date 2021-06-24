package com.johnathan.challenger.series

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnathan.challenger.FilmRepository
import com.johnathan.challenger.api.dto.Film
import com.johnathan.challenger.util.Constants
import kotlinx.coroutines.launch

class SeriesViewModel : ViewModel() {
    private var _seriesList = MutableLiveData<MutableList<Film>>()
    private val homeRepository = FilmRepository()
    init {
        viewModelScope.launch {
            _seriesList.value = homeRepository.getAllMovies(Constants.SERIES)
        }
    }
    val seriesLiveData: LiveData<MutableList<Film>> = _seriesList
}