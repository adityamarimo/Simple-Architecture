package com.moja.simplecleanarchitecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moja.simplecleanarchitecture.databinding.ActivityMainBinding
import com.moja.simplecleanarchitecture.presentation.MainViewModel
import com.moja.simplecleanarchitecture.presentation.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = MainViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        viewModel.setName("Aditya Salman")
        viewModel.message.observe(this, {
            binding.tvWelcome.text = it.welcomeMessage
        })
    }
}