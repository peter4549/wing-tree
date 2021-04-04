package com.duke.orca.android.kotlin.wingtree.study.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.duke.orca.android.kotlin.wingtree.databinding.StudyItemBinding
import com.duke.orca.android.kotlin.wingtree.study.data.Study

class StudyAdapter(private val onItemClick: (Study) -> Unit): ListAdapter<Study, StudyAdapter.ViewHolder>(DiffCallback()) {
    private var inflater: LayoutInflater? = null

    inner class ViewHolder(private val binding: StudyItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Study) {
            binding.likeButton.isLiked = item.bookmark
            binding.root.setBackgroundColor(item.color)
            binding.textViewName.text = item.name
            binding.textViewUserCount.text = item.users.count().toString()

            binding.root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    private fun from(parent: ViewGroup): ViewHolder {
        return ViewHolder(StudyItemBinding.inflate(
            inflater ?: LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffCallback: DiffUtil.ItemCallback<Study>() {
    override fun areItemsTheSame(oldItem: Study, newItem: Study): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Study, newItem: Study): Boolean {
       return oldItem == newItem
    }
}