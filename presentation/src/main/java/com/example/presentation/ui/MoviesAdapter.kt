package com.example.presentation.ui

import com.example.presentation.R
import com.example.presentation.base.BaseAdapter
import com.example.presentation.base.BaseViewHolder
import com.example.presentation.model.MovieItem

class MoviesAdapter(itemClick: (MovieItem) -> Unit) : BaseAdapter<MovieItem>(itemClick) {

    override fun layoutRes(): Int = R.layout.item_movie_view
    override fun onViewHolderCreated(viewHolder: BaseViewHolder<MovieItem>) {

    }
}