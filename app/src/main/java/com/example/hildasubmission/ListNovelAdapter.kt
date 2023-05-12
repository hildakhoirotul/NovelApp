package com.example.hildasubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView

class ListNovelAdapter(private val listNovel: ArrayList<Novel>) : RecyclerView.Adapter<ListNovelAdapter.ListViewHolder>(){
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val novelCover: ImageView = itemView.findViewById(R.id.img_item_photo)
        val novelTitle: TextView = itemView.findViewById(R.id.tv_item_name)
        val novelDesc: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.novel_item, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listNovel.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, isbn, publisher, page, size) = listNovel[position]
        holder.novelCover.setImageResource(photo)
        holder.novelTitle.text = name
        holder.novelDesc.text = description

        holder.itemView.setOnClickListener {
        val intentDetail = Intent(holder.itemView.context, DetailNovel::class.java).apply {
            putExtra("key_hero", listNovel[holder.adapterPosition])
            putExtra("isbn",isbn)
            putExtra("publisher",publisher)
            putExtra("page",page)
            putExtra("size",size)
        }
            holder.itemView.context.startActivity(intentDetail)
        }
    }

}