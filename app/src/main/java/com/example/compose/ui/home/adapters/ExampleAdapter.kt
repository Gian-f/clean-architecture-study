package com.example.compose.ui.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.compose.R
import com.example.compose.domain.model.Example

class ExampleAdapter : ListAdapter<Example,ExampleAdapter.ViewHolder>(WordsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val shortDescription: TextView = itemView.findViewById(R.id.shortDescription)
        private val longDescription: TextView = itemView.findViewById(R.id.longDescription)

        fun bind(example: Example?) {
            shortDescription.text = example?.shortDescription
            longDescription.text = example?.longDescription
        }

        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item, parent, false)
                return ViewHolder(view)
            }
        }
    }

    class WordsComparator : DiffUtil.ItemCallback<Example>() {
        override fun areItemsTheSame(oldItem: Example, newItem: Example): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Example, newItem: Example): Boolean {
            return oldItem.uuid == newItem.uuid
        }
    }
}