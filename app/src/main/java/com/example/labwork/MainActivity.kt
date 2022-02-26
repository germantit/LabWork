package com.example.labwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labwork.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(viewModelStore, defaultViewModelProviderFactory)
            .get(MainViewModel::class.java)
        val adapter = RwAdapter()
        viewModel.list.observe(this) {
            adapter.setRecord(it)
        }
        binding.button.setOnClickListener {
            viewModel.addStr(binding.editTextNewRecord.text.toString())
            adapter.notifyDataSetChanged()
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}