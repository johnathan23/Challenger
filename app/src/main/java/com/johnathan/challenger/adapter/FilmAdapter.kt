package com.johnathan.challenger.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.johnathan.challenger.R
import com.johnathan.challenger.api.dto.Film
import com.johnathan.challenger.databinding.ItemFilmBinding
import com.johnathan.challenger.util.Constants
import com.johnathan.challenger.util.Util


class FilmAdapter(val context : Context) : ListAdapter<Film, FilmAdapter.FilmViewHolder>(DiffCallback){

    companion object DiffCallback : DiffUtil.ItemCallback<Film>() {
        override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem == newItem
        }
    }

    lateinit var onItemClickListener: (Film) -> Unit

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FilmAdapter.FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_film ,parent , false)
        return FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmAdapter.FilmViewHolder, position: Int) {
        val film = getItem(position)
        holder.bind(film)
    }

    inner class FilmViewHolder(private val view : View): RecyclerView.ViewHolder(view){

        private  val binding = ItemFilmBinding.bind(view)

        fun bind(film: Film) {
            binding.ivIcon.setImageResource(validateTypeFilm(film.type))
            binding.tvName.text = film.name
            view.setOnClickListener{
                Util.showToast(context,  "${film.name} is clicked")
                if(::onItemClickListener.isInitialized){
                    onItemClickListener(film)
                }else{
                    Util.addLog("onItemClickListener not initialized", null)
                }
            }
        }
    }
}

private fun validateTypeFilm(type: String) : Int {
    return when (type) {
        Constants.MOVIE -> {
            R.drawable.ic_movies
        }
        else -> {
            R.drawable.ic_series
        }
    }
}