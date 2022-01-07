package com.github.prabalhazra.keepsremind.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.github.prabalhazra.keepsremind.databinding.ActivityMainBinding
import com.github.prabalhazra.keepsremind.db.NoteDatabase
import com.github.prabalhazra.keepsremind.repository.NoteRepository
import com.github.prabalhazra.keepsremind.viewModel.NoteActivityViewModel
import com.github.prabalhazra.keepsremind.viewModel.NoteActivityViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var noteActivityViewModel: NoteActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            val noteRepository = NoteRepository(NoteDatabase(this))
            val noteActivityViewModelFactory = NoteActivityViewModelFactory(noteRepository)
            noteActivityViewModel = ViewModelProvider(this, noteActivityViewModelFactory)[NoteActivityViewModel::class.java]
        } catch (e: Exception) {

        }
    }
}