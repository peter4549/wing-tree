package com.duke.orca.android.kotlin.wingtree.notification.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.duke.orca.android.kotlin.wingtree.databinding.NotificationItemBinding

class NotificationAdapter(private val onItemClick: (binding: NotificationItemBinding, item: NotificationItem) -> Unit):
    RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {
    private val notifications = arrayListOf<NotificationItem>()

    fun addAll(list: List<NotificationItem>) {
        val positionStart = notifications.count()
        notifications.addAll(list)
        notifyItemRangeChanged(positionStart, list.count())
    }

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
        holder.bind(notifications[position])
    }

    override fun getItemCount(): Int = notifications.count()
}

data class NotificationItem(
    val action: String,
    val message: String,
    val registrationTime: Long,
    val studyName: String,
)