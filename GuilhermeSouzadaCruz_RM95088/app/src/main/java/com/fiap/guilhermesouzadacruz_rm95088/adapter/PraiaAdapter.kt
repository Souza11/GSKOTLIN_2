package com.fiap.guilhermesouzadacruz_rm95088.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemBinding
import com.fiap.guilhermesouzadacruz_rm95088.model.Praia

class ItemsAdapter(private val items: List<Praia>) : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemModel) {
            binding.textViewName.text = item.nome
            binding.textViewCity.text = item.city
            binding.textViewState.text = item.state
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}