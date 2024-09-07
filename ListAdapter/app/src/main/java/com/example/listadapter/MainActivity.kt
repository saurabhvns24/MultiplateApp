package com.example.listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.listadapter.api.QuotesServiceAPI
import com.example.listadapter.api.RetrofitHelper
import com.example.listadapter.repository.QuoteRepository
import com.example.listadapter.viewmodel.QuoteViewModel
import com.example.listadapter.viewmodel.QuoteViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    lateinit var quoteViewModel: QuoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = (application as QuoteApplication).repository
        quoteViewModel =
            ViewModelProvider(this, QuoteViewModelFactory(repository))[QuoteViewModel::class.java]
        quoteViewModel.quotes.observe(this, Observer {
            Log.d(TAG, "onCreate: " + it)
        })
    }
}