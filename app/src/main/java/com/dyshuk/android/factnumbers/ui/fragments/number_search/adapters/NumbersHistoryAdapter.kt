package com.dyshuk.android.factnumbers.ui.fragments.number_search.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dyshuk.android.factnumbers.databinding.HistoryNumberItemBinding
import com.dyshuk.android.factnumbers.domain.Number

class NumbersHistoryAdapter : ListAdapter<Number, NumbersHistoryAdapter.NumbersHistoryViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersHistoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NumbersHistoryViewHolder(HistoryNumberItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: NumbersHistoryViewHolder, position: Int) {
        val number = getItem(position)
        holder.bind(number)
    }

    class NumbersHistoryViewHolder(private val binding: HistoryNumberItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(number: Number) {
            binding.apply {

            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Number>() {
        override fun areItemsTheSame(oldItem: Number, newItem: Number): Boolean {
            return oldItem.text == newItem.text
        }

        override fun areContentsTheSame(oldItem: Number, newItem: Number): Boolean {
            return oldItem == newItem
        }
    }
}