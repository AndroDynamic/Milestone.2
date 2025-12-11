package com.example.mealprepproper

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.launch
import androidx.core.view.updatePadding
import com.google.android.material.bottomnavigation.BottomNavigationView
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private fun setCalorieCount(inputBox: EditText, calorieLabel: TextView) {
        val query: String = inputBox.text.toString()

        if (query.length > 0) {

            lifecycleScope.launch {
                try {
                    val response = MacroClient.api.searchFoods(query)

                    println(response.items)

                    if (!(response.items.isNullOrEmpty())) {
                        var totalCalories: Double = 0.0

                        for (i in 0 until response.items.size) {
                            totalCalories += response.items[i].calories
                        }

                        calorieLabel.text = "$totalCalories kcal"
                    }
                } catch (e: Exception) {
                    Log.e("RecipeSearchActivity", "API call failed with error: ${e.message}", e)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        ViewCompat.setOnApplyWindowInsetsListener(scrollView) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.navPlanner -> {
                    // Stay on this screen
                    true
                }

                R.id.navRecipes -> {
                    // Open Recipe Search screen
                    startActivity(Intent(this, RecipeSearchActivity::class.java))
                    true
                }

                R.id.groceryList -> {
                    // Open Grocery List screen
                    startActivity(Intent(this, GroceryListActivity::class.java))

                    true
                }

                else -> false
            }
        }

        val meals: MutableList<String> = mutableListOf("Breakfast", "Lunch", "Dinner")
        val days: MutableList<String> = mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val prefixes: MutableList<String> = mutableListOf()

        for (meal in meals) {
            for (day in days) {
                val newPrefix = day + meal
                prefixes.add(newPrefix)
            }
        }

        for (prefix in prefixes) {
            val inputBox: EditText = findViewById<EditText>(resources.getIdentifier(prefix + "Input", "id", getPackageName()))
            val calorieCount: TextView = findViewById<TextView>(resources.getIdentifier(prefix + "Cal", "id", getPackageName()))

            inputBox.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setCalorieCount(inputBox, calorieCount)

                    true
                } else {
                    false
                }
            }
        }
    }
}