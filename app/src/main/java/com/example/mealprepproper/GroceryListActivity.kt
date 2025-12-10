package com.example.mealprepproper


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealprepproper.databinding.ActivityGroceryListBinding

class GroceryListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGroceryListBinding
    private val groceryList = mutableListOf<String>()
    private lateinit var adapter: GroceryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroceryListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = GroceryAdapter(groceryList)
        binding.groceryRecycler.layoutManager = LinearLayoutManager(this)
        binding.groceryRecycler.adapter = adapter

        binding.addItemBtn.setOnClickListener {
            val item = binding.addItemInput.text.toString().trim()
            if (item.isNotEmpty()) {
                groceryList.add(item)
                adapter.notifyItemInserted(groceryList.size - 1)
                binding.addItemInput.text.clear()
            }
        }
    }
}