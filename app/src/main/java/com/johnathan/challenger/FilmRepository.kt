package com.johnathan.challenger

import com.johnathan.challenger.api.dto.Film
import com.johnathan.challenger.api.service
import com.johnathan.challenger.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmRepository {

    suspend fun getAllMovies(type : String): MutableList<Film> {
        return withContext(Dispatchers.IO){
            val result = service.getFilms(Constants.UID)
            filter(type, result.films)
        }
    }

    private fun filter(type: String, list: List<Film>) : MutableList<Film> {
        return when(type){
            Constants.MOVIE -> list.filter { film -> film.type == type }.toMutableList()
            Constants.SERIES -> list.filter { film -> film.type == type }.toMutableList()
            else -> {
                list.toMutableList()
            }
        }
    }
}

