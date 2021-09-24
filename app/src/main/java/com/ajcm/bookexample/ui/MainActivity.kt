package com.ajcm.bookexample.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajcm.bookexample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.model.observe(this, Observer(::updateUi))

        binding.btnTryAgain.setOnClickListener {
            viewModel.refresh()
        }
    }

    private fun updateUi(model: UiModel) {
        with(binding) {
            when(model) {
                UiModel.Loading -> {
                    progressLoader.visibility = View.VISIBLE
                    parentRecyclerView.visibility = View.GONE
                    loadErrorText.visibility = View.GONE
                    btnTryAgain.visibility = View.GONE
                }
                UiModel.ShowError -> {
                    progressLoader.visibility = View.GONE
                    parentRecyclerView.visibility = View.GONE
                    loadErrorText.visibility = View.VISIBLE
                    btnTryAgain.visibility = View.VISIBLE
                }
                is UiModel.Content -> {
                    progressLoader.visibility = View.GONE
                    loadErrorText.visibility = View.GONE
                    btnTryAgain.visibility = View.GONE
                    parentRecyclerView.visibility = View.VISIBLE
                    parentRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    parentRecyclerView.adapter = BooksAdapter(model.books)
                }
            }
        }
    }
}
