package com.example.presentation.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.BR
import timber.log.Timber

abstract class BaseAdapter<T : BaseParcelable>(
    private val itemClick: (T) -> Unit = {}
) : ListAdapter<T, BaseViewHolder<T>>(BaseItemCallback()) {

    var mCurrentList = arrayListOf<T?>()

    private var mPosition: Int = 0

    @LayoutRes
    abstract fun layoutRes(): Int

    abstract fun onViewHolderCreated(viewHolder: BaseViewHolder<T>)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutRes(),
            parent,
            false
        )
        return BaseViewHolder<T>(binding).apply {
            onViewHolderCreated(this)
            itemView.setOnClickListener {
                this@BaseAdapter.mPosition = adapterPosition
                itemClick(getItem(adapterPosition))
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(getItem(position))
    }

    fun removeItem(item: T?, isListEmpty: (Boolean) -> Unit = {}) {
        Timber.e("deleting > $item in pos: $mPosition")
        item?.let {
            mCurrentList.remove(it)
            submitList(mCurrentList.toMutableList())
            isListEmpty(mCurrentList.size == 0)
        }
    }

    fun updateList(newList: List<T>) {
        mCurrentList.addAll(newList)
        submitList(mCurrentList.toMutableList())
    }

    fun setList(newList: List<T?>) {
        mCurrentList.clear()
        mCurrentList.addAll(newList)
        submitList(mCurrentList.toMutableList())
    }

    fun addItemToList(item: T?, isAdded: (Boolean) -> Unit) {
        item?.let {
            mCurrentList.add(item)
            submitList(mCurrentList.toMutableList())
            isAdded(true)
        } ?: Timber.e("item is null")
    }

    fun editItem(item: T?) {
        item?.let {
            mCurrentList[mPosition] = item
            submitList(mCurrentList.toMutableList())
        } ?: Timber.e("item is null")
    }

    fun clearCurrentList() {
        mCurrentList.clear()
        submitList(mCurrentList.toMutableList())
    }

}

class BaseViewHolder<T>(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: T) {
        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }
}

class BaseItemCallback<T : BaseParcelable> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) =
        oldItem.unique().toString() == newItem.unique().toString()

    override fun areContentsTheSame(oldItem: T, newItem: T) =
        oldItem.equals(newItem)
}

interface BaseParcelable {
    fun unique(): Any
}