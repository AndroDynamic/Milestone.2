package com.example.mealprepproper

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealprepproper.databinding.ItemGroceryBinding

class GroceryAdapter(private val items: MutableList<String>) :
    RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder>() {

    inner class GroceryViewHolder(val binding: ItemGroceryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val binding = ItemGroceryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GroceryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        holder.binding.groceryItemText.text = items[position]

        holder.binding.deleteBtn.setOnClickListener {
            items.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, items.size)
        }
    }

    override fun getItemCount(): Int = items.size
}