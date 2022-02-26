package com.example.labwork

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.labwork.databinding.RvItemBinding

class RwAdapter() :
    RecyclerView.Adapter<RwAdapter.MyViewHolder>() {

    private val records = mutableListOf<String>()


    class MyViewHolder(rvItemBinding: RvItemBinding)
        : RecyclerView.ViewHolder(rvItemBinding.root) {
        private val binding = rvItemBinding

        fun bind(record: String) {
            binding.textViewRecord.text = record
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RvItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val record = records[position]
        holder.bind(record)
    }

    override fun getItemCount(): Int {
        return records.size
    }

    fun addRecord(str: String) {
        records.add(str)
        notifyItemInserted(records.lastIndex)
    }

    fun setRecord(list: List<String>) {
        records.clear()
        records.addAll(list)
        notifyDataSetChanged()
    }
}