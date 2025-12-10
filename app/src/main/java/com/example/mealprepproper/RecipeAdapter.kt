package com.example.mealprepproper

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter // <-- Add this import
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecipeAdapter : ListAdapter<Meal, RecipeAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<Meal>() {
        override fun areItemsTheSame(a: Meal, b: Meal) = a.idMeal == b.idMeal
        override fun areContentsTheSame(a: Meal, b: Meal) = a == b
    }
) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.mealName)
        val image = view.findViewById<ImageView>(R.id.mealImage)

        val calories: TextView = view.findViewById(R.id.mealCalories)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meal = getItem(position)

        holder.name.text = meal.strMeal
        Glide.with(holder.itemView).load(meal.strMealThumb).into(holder.image)

        holder.calories.text = "Approx. 300 cal"

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, RecipeDetailsActivity::class.java)
            intent.putExtra("mealId", meal.idMeal)
            holder.itemView.context.startActivity(intent)
        }
    }
}