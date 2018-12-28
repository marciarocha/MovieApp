package com.marciarocha.movieapp.moviemain

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.marciarocha.movieapp.R
import com.marciarocha.movieapp.data.model.Movie
import com.marciarocha.movieapp.data.remote.POSTER_PATH
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieMainAdapter constructor(val activityContext: Context) : RecyclerView.Adapter<MovieMainAdapter.MovieViewHolder>() {

    private val movieList = ArrayList<Movie>()
    private var mListener: OnMovieItemClickListener? = null

    fun setOnMovieItemClickListener(onMovieItemClickListener: OnMovieItemClickListener) {
        mListener = onMovieItemClickListener
    }

    fun addItems(newMovieList:List<Movie>) {
        movieList.clear()
        movieList.addAll(newMovieList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    inner class MovieViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) = with(itemView) {
            title.text = movie.title
            year.text = movie.releaseDate
            movie.posterPath?.let{
                Glide.with(activityContext)
                        .load(POSTER_PATH + it)
                        .into(movie_poster)

            }
            movie_item_layout.setOnClickListener { mListener?.onItemClick(movie.id) }
            if (movie.isCurrentYear()){
                year.setTextColor(Color.RED)
            } else {
                year.setTextColor(Color.WHITE)
            }
        }
    }

    interface OnMovieItemClickListener {
        fun onItemClick(id: Int)
    }
}