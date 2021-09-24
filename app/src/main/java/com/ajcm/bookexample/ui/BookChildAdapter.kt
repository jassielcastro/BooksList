package com.ajcm.bookexample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajcm.bookexample.R
import com.ajcm.bookexample.databinding.ItemBookSectionsBinding
import com.ajcm.domain.entities.Book

class BookChildAdapter(private val books: List<Book>) :
    RecyclerView.Adapter<BookChildAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemBookSectionsBinding.bind(view)

        fun bind(book: Book) {
            binding.titleBook.text = book.title
            binding.authorBook.text = book.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_book_sections, parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int = books.size

}
