package com.example.mealprepproper

import android.os.Bundle
import android.util.Log

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
class RecipeSearchActivity : AppCompatActivity() {
    private lateinit var adapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_search)

        adapter = RecipeAdapter()
        findViewById<RecyclerView>(R.id.recipeRecycler).adapter = adapter
        findViewById<RecyclerView>(R.id.recipeRecycler).layoutManager =
            LinearLayoutManager(this)

        val searchInput = findViewById<EditText>(R.id.searchInput)
        val searchButton = findViewById<Button>(R.id.searchButton)

        searchButton.setOnClickListener {
            val term = searchInput.text.toString()
            if (term.isNotEmpty()) fetchMeals(term)
        }
    }

    private fun fetchMeals(query: String) {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.api.searchMeals(query)
                if (response.meals.isNullOrEmpty()) {
                    adapter.submitList(emptyList()) // Clear the list
                    Toast.makeText(this@RecipeSearchActivity, "No meals found for '$query'", Toast.LENGTH_LONG).show()
                } else {
                    adapter.submitList(response.meals)
                }

            } catch (e: Exception) {

                Log.e("RecipeSearchActivity", "API call failed with error: ${e.message}", e)
                Toast.makeText(this@RecipeSearchActivity, "Error fetching data. Check connection.", Toast.LENGTH_LONG).show()
            }
        }
    }
}

