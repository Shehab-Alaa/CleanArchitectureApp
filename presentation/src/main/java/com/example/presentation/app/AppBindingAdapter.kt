package com.example.presentation.app

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("adapter")
fun setRecyclerAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>?) {
    adapter?.let {
        recyclerView.adapter = it
        recyclerView.setHasFixedSize(true)
    }
}

