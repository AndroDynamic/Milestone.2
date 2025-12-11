package com.example.mealprepproper

import android.content.Intent
import android.os.Bundle
import android.widget.ScrollView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
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
    }
}