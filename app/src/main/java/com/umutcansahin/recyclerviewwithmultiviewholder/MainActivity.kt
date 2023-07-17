package com.umutcansahin.recyclerviewwithmultiviewholder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.umutcansahin.recyclerviewwithmultiviewholder.adapter.TodoAdapter
import com.umutcansahin.recyclerviewwithmultiviewholder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val todoAdapter by lazy { TodoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoList = TodoDb.getTodos()

        todoAdapter.updateList(todoList)

        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = todoAdapter
        }
    }
}