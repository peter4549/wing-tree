package com.duke.orca.android.kotlin.wingtree.notification.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.duke.orca.android.kotlin.wingtree.databinding.NotificationItemBinding
import com.duke.orca.android.kotlin.wingtree.notification.data.NotificationItem

class NotificationAdapter(private val onItemClick: (binding: NotificationItemBinding, item: NotificationItem) -> Unit):
    ListAdapter<NotificationItem, NotificationAdapter.ViewHolder>(NotificationDiffCallback()) {

    inner class ViewHolder(private val binding: NotificationItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NotificationItem) {
            binding.textViewAction.text = item.action
            binding.textViewMessage.text = item.message
            binding.textViewRegistrationTime.text = item.action
            binding.textViewAction.text = item.action

            binding.root.setOnClickListener {
                onItemClick(binding, item)
            }
        }
    }

    private fun from(parent: ViewGroup): ViewHolder {
        val binding = NotificationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class NotificationDiffCallback(): DiffUtil.ItemCallback<NotificationItem>() {
    override fun areItemsTheSame(oldItem: NotificationItem, newItem: NotificationItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NotificationItem, newItem: NotificationItem): Boolean {
        return oldItem == newItem
    }
}