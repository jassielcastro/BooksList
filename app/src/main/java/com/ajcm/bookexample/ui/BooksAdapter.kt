package com.ajcm.bookexample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajcm.bookexample.R
import com.ajcm.bookexample.databinding.ItemBooksBinding

class BooksAdapter(private val bookSections: List<BooksSections>) :
    RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemBooksBinding.bind(view)

        fun bind(sections: BooksSections) {
            binding.titleSection.text = sections.section.name
            binding.countSection.text = "${sections.books.size}"
            val childMembersAdapter = BookChildAdapter(sections.books)
            binding.recyclerBooks.layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            binding.recyclerBooks.adapter = childMembersAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_books, parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sections = bookSections[position]
        holder.bind(sections)
    }

    override fun getItemCount(): Int = bookSections.size

}
