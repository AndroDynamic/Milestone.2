package com.example.mealprepproper

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.mealprepproper.Meal
import kotlinx.coroutines.launch
class RecipeDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        val mealId = intent.getStringExtra("mealId")
        if (mealId.isNullOrBlank()) {
            Toast.makeText(this, "Error: Meal ID not found", Toast.LENGTH_LONG).show()
            finish() // Close the activity if there's no ID
            return
        }

        lifecycleScope.launch {
            try {
                // This calls the lookup.php endpoint
                val response = RetrofitClient.api.lookupMeal(mealId)
                val meal = response.meals?.firstOrNull()

                if (meal != null) {
                    // 3. Update the UI with the details
                    updateUi(meal)
                } else {
                    Toast.makeText(this@RecipeDetailsActivity, "Could not load recipe details", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Log.e("RecipeDetailsActivity", "API call failed", e)
                Toast.makeText(this@RecipeDetailsActivity, "Error loading details", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun updateUi(meal: Meal) {
        val titleTextView = findViewById<TextView>(R.id.title)
        val instructionsTextView = findViewById<TextView>(R.id.instructions)
        val imageView = findViewById<ImageView>(R.id.image)

        titleTextView.text = meal.strMeal
        instructionsTextView.text = meal.strInstructions
        Glide.with(this)
            .load(meal.strMealThumb)
            .into(imageView)
    }
}